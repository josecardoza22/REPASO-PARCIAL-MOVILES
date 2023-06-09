package com.example.repasoparcial

import android.app.Application
import com.example.repasoparcial.data.products
import com.example.repasoparcial.repository.ProductRepository

class ProductReviewerApplication {
    val productRepository: ProductRepository by lazy {
        ProductRepository(products)
    }
}