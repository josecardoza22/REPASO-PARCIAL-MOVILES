package com.example.repasoparcial.ui.product.feed.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repasoparcial.data.models.ProductModel
import com.example.repasoparcial.databinding.ProductItemBinding


class ProductRecycleViewAdapter (
    private val clickListener: (ProductModel) -> Unit) : RecyclerView.Adapter<ProductRecycleViewHolder>() {
    private val products = ArrayList<ProductModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductRecycleViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductRecycleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductRecycleViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product, clickListener)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setData(productsList: List<ProductModel>) {
        products.clear()
        products.addAll(productsList)
    }

}