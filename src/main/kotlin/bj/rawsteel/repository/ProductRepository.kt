package bj.rawsteel.repository

import bj.rawsteel.domain.Product
import bj.rawsteel.domain.Sku
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:04
 */

interface ProductRepository : JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product>

interface SkuRepository : JpaRepository<Sku, Long>, QuerydslPredicateExecutor<Sku>
