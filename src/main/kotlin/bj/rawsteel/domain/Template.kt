package bj.rawsteel.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

/**
 * Created by BaiJiFeiLong@gmail.com at 18-7-8 下午4:10
 */
@Entity
data class Template(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
        @Column @CreationTimestamp var createdAt: Date?,
        @Column @UpdateTimestamp var updatedAt: Date?
) {
    constructor() : this(null, null, null)
}