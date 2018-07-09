package bj.rawsteel.service

import bj.rawsteel.domain.QUser
import bj.rawsteel.domain.User
import bj.rawsteel.exception.RegisterException
import bj.rawsteel.repository.UserRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.crypto.MacProvider
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource
import javax.security.auth.login.LoginException

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午7:10
 */
@Service
class UserService : BaseService() {

    @Resource
    private lateinit var userRepository: UserRepository

    private val key = MacProvider.generateKey()

    fun findAll(username: String?, pageable: Pageable = PageRequest.of(0, 100)): Page<User> {
        var predicate = QUser.user.isNotNull
        if (username != null) {
            predicate = predicate.and(QUser.user.username.eq(username))
        }
        return userRepository.findAll(predicate, pageable)
    }

    fun findByUsername(username: String): Optional<User> {
        return userRepository.findOne(QUser.user.username.eq(username))
    }

    fun findById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    fun findByIdOrThrow(id: Long): User {
        return findById(id).orElseThrow { RuntimeException("User(id=$id) not exist") }
    }

    fun create(username: String, password: String): User {
        val user = User().apply {
            this.username = username
            this.password = password
        }
        return userRepository.save(user)
    }

    fun update(id: Long, username: String?): User {
        val user = findByIdOrThrow(id)
        if (username != null) {
            user.username = username;
        }
        return userRepository.save(user)

    }

    fun destroy(id: Long) {
        findByIdOrThrow(id)
        userRepository.deleteById(id)
    }

    fun findByToken(token: String): Optional<User> {
        val username = Jwts.parser().setSigningKey(key).parseClaimsJws(token).body.subject
        return findByUsername(username)
    }

    fun findByTokenOrThrow(token: String): User {
        return findByToken(token).orElseThrow {
            LoginException(getMessage("AUTH_FAILED_TOKEN_INVALID"))
        }
    }

    fun register(username: String, password: String): User {
        findByUsername(username).ifPresent { throw RegisterException(getMessage("REGISTER_FAILED_USERNAME_EXIST", username)) }
        return create(username, password)
    }

    fun login(username: String, password: String): User {
        return findByUsername(username).orElseThrow { LoginException(getMessage("LOGIN_FAILED_USERNAME_NOT_EXIST", username)) }.apply {
            token = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS256, key).compact()
        }
    }

    fun registerAndLogin(username: String, password: String): User {
        register(username, password)
        return login(username, password)
    }
}