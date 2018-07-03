package bj.rawsteel.service

import bj.rawsteel.domain.QUser
import bj.rawsteel.domain.User
import bj.rawsteel.repository.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午7:10
 */
@Service
class UserService {

    @Resource
    private lateinit var userRepository: UserRepository

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

    fun create(username: String): User {
        val user = User()
        user.username = username
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
}