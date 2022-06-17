package samesya.kotlin.restful.repository

import org.springframework.data.jpa.repository.JpaRepository
import samesya.kotlin.restful.entity.Product

interface ProductRepository : JpaRepository<Product, String> {}
