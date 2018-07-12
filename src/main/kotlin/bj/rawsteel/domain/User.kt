package bj.rawsteel.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午3:43
 */
@Entity
class User : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority("user"))
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String? {
        return username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String? {
        return password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    override fun toString(): String {
        return "User(id=$id, username=$username, password=$password, nickname=$nickname, avatar=$avatar, age=$age, createdAt=$createdAt, updatedAt=$updatedAt, token=$token)"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    private var username: String? = null

    @Column
    private var password: String? = null

    @Column
    var nickname: String? = null

    @Column
    var avatar: String? = null

    @Column
    var age: Int? = null

    @Column
    @CreationTimestamp
    var createdAt: Date? = null

    @Column
    @UpdateTimestamp
    var updatedAt: Date? = null

    @Transient
    var token: String? = null
}