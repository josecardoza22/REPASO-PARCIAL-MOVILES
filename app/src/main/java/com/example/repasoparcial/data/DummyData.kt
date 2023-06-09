package com.example.repasoparcial.data
import com.example.repasoparcial.data.models.ProductModel

val name = "Smart Watch"
val user = "jose.cardoza"
val price = "$9.99"

val name2 = "Camisa Polo"
val user2 = "carlos.cardoza"
val price2 = "$25.00"

val name3 = "Television Samsung"
val user3 = "carmen.cardoza"
val price3 = "$105.95"

val products = mutableListOf(
    ProductModel(name, user, price),
    ProductModel(name2, user2, price2),
    ProductModel(name3, user3, price3)
)