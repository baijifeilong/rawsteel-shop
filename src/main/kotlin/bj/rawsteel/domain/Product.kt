package bj.rawsteel.domain

import java.util.*
import javax.persistence.*

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 上午10:45
 */
@Entity
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column
    var name: String? = null
    @Column
    var createdAt: Date? = null
    @Column
    var updatedAt: Date? = null

    override fun toString(): String {
        return "Product(id=$id, name=$name, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}

@Entity
class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column
    var name: String? = null
    @Column
    var productId: Long? = null
    @Column
    var price: Long? = null
    @Column
    var createdAt: Date? = null
    @Column
    var updatedAt: Date? = null

    override fun toString(): String {
        return "Sku(id=$id, name=$name, productId=$productId, price=$price, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}