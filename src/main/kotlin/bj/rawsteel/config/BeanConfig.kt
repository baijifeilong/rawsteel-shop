package bj.rawsteel.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/10 上午10:14
 */
@SpringBootConfiguration
open class BeanConfig {

    @Bean
    open fun objectMapper() = ObjectMapper()

    @Bean
    open fun restTemplate() = RestTemplate()
}