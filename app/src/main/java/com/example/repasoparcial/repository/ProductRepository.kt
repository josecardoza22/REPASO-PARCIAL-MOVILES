package com.example.repasoparcial.repository

import com.example.repasoparcial.data.models.ProductModel

class ProductRepository(private val products: MutableList<ProductModel>) {
    fun getProducts() = products

    fun addProducts(newProduct: ProductModel) = products.add(newProduct)
}