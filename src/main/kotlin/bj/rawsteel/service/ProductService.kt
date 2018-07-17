package bj.rawsteel.service

import bj.rawsteel.domain.QProduct
import bj.rawsteel.domain.Product
import bj.rawsteel.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:10
 */
@Service
class ProductService {

    @Resource
    private lateinit var productRepository: ProductRepository;

    fun findAll(pageable: Pageable): Page<Product> {
        val predicate = QProduct.product.isNotNull
        return productRepository.findAll(predicate, pageable)
    }

    fun findAll(): List<Product> {
        return productRepository.findAll()
    }

    fun findById(id: Long): Optional<Product> {
        return productRepository.findById(id)
    }

    fun findByIdOrThrow(id: Long): Product {
        return findById(id).orElseThrow { RuntimeException("Product(id=$id) not exist") }
    }

    fun create(name: String): Product {
        val product = Product().apply {
            createdAt = Date()
            updatedAt = createdAt
            this.name = name
        }
        productRepository.save(product)
        return product
    }

    fun update(id: Long): Product {
        val product = findByIdOrThrow(id).apply {
            updatedAt = Date()
        }
        productRepository.save(product)
        return product
    }

    fun destroy(id: Long) {
        findByIdOrThrow(id)
        productRepository.deleteById(id)
    }

    fun destroyAll() {
        productRepository.deleteAll()
    }
}