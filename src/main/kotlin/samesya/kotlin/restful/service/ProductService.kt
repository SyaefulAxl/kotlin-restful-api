package samesya.kotlin.restful.service

import samesya.kotlin.restful.model.CreateProductRequest
import samesya.kotlin.restful.model.ListProductRequest
import samesya.kotlin.restful.model.ProductResponse
import samesya.kotlin.restful.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}
