package com.example.repasoparcial.ui.product.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.repasoparcial.ProductReviewerApplication
import com.example.repasoparcial.data.models.ProductModel
import com.example.repasoparcial.repository.ProductRepository

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
    var name: MutableLiveData<String> = MutableLiveData("")
    var user = MutableLiveData("")
    var price = MutableLiveData("")
    var status = MutableLiveData("")

    fun getProducts() = repository.getProducts()

    fun addProducts(product: ProductModel) = repository.addProducts(product)

    private fun validateData(): Boolean{
        when {
            name.value.isNullOrEmpty() -> return false
            user.value.isNullOrEmpty() -> return false
            price.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createProduct() {

        if(!validateData()){
            status.value = WRONG_DATA
            return
        }
        val newProduct = ProductModel(
            name.value.toString(),
            user.value.toString(),
            price.value.toString(),
        )

        addProducts(newProduct)
        status.value = PRODUCT_CREATE
    }

    fun clearData() {
        name.value = ""
        user.value = ""
        price.value = ""
    }

    fun clearStatus() {
        status.value = BASE_STATE
    }

    fun setSelectedProduct (product: ProductModel){
        name.value = product.name
        user.value = product.user
        price.value = product.price
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ProductReviewerApplication
                ProductViewModel(app.productRepository)
            }
        }
        const val PRODUCT_CREATE = "Producto Creado"
        const val WRONG_DATA = "Wrong Data"
        const val BASE_STATE = ""
    }
}