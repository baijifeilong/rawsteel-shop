package bj.rawsteel.config

import bj.rawsteel.domain.ApiFailure
import bj.rawsteel.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.SpringBootConfiguration
import org.springframework.http.MediaType
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.NegatedRequestMatcher
import org.springframework.security.web.util.matcher.OrRequestMatcher
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.Resource
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 下午2:20
 */
@SpringBootConfiguration
open class SecurityConfig : WebSecurityConfigurerAdapter() {
    companion object {
        val PUBLIC_URLS = arrayOf(
                "/",
                "/api/users/login",
                "/api/users/register"
        )
    }

    @Resource
    private lateinit var tokenAuthenticationProvider: TokenAuthenticationProvider

    private val objectMapper = ObjectMapper().writerWithDefaultPrettyPrinter()

    override fun configure(web: WebSecurity?) {
        web?.ignoring()?.antMatchers(
                "/v2/api-docs",
                "/configuration/**",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/lorem/**"
        )
    }

    override fun configure(http: HttpSecurity?) {
        val protectedUrls = NegatedRequestMatcher(OrRequestMatcher(PUBLIC_URLS.map { AntPathRequestMatcher(it) }))
        http?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ?.and()?.exceptionHandling()?.authenticationEntryPoint { _, response, e ->
                    response.status = 401
                    response.contentType = MediaType.APPLICATION_JSON_UTF8_VALUE
                    response.writer.write(objectMapper.writeValueAsString(ApiFailure.of(401, "Unauthorized: No token or invalid token")))
                }
                ?.and()?.authenticationProvider(tokenAuthenticationProvider)
                ?.addFilterBefore(TokenAuthenticationFilter(protectedUrls).apply {
                    this.setAuthenticationManager(this@SecurityConfig.authenticationManager())
                    this.setAuthenticationSuccessHandler(SimpleUrlAuthenticationSuccessHandler().apply {
                        this.setRedirectStrategy { _, _, _ -> }
                    })
                }, AnonymousAuthenticationFilter::class.java)
                ?.authorizeRequests()?.antMatchers(*PUBLIC_URLS)?.permitAll()?.anyRequest()?.authenticated()
                ?.and()?.csrf()?.disable()?.formLogin()?.disable()?.httpBasic()?.disable()?.logout()?.disable()
    }
}

@Component
class TokenAuthenticationProvider : AbstractUserDetailsAuthenticationProvider() {

    @Resource
    private lateinit var userService: UserService

    override fun retrieveUser(username: String?, authentication: UsernamePasswordAuthenticationToken?): UserDetails {
        val token = authentication?.credentials.toString()
        return userService.findByTokenOrThrow(token)
    }

    override fun additionalAuthenticationChecks(userDetails: UserDetails?, authentication: UsernamePasswordAuthenticationToken?) {}

}

class TokenAuthenticationFilter(matcher: RequestMatcher?) : AbstractAuthenticationProcessingFilter(matcher) {
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val token = Optional.ofNullable(request?.getHeader("Authorization")).map { it.removePrefix("Bearer").trim() }
                .orElseThrow { BadCredentialsException("No token") }
        return authenticationManager.authenticate(UsernamePasswordAuthenticationToken(token, token))
    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {
        super.successfulAuthentication(request, response, chain, authResult)
        chain?.doFilter(request, response)
    }

    override fun doFilter(req: ServletRequest?, res: ServletResponse?, chain: FilterChain?) {
        if (req is HttpServletRequest && req.requestURI == "/error") {
            chain?.doFilter(req, res)
        } else {
            super.doFilter(req, res, chain)
        }
    }
}