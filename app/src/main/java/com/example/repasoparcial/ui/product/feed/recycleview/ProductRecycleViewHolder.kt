package com.example.repasoparcial.ui.product.feed.recycleview

import androidx.recyclerview.widget.RecyclerView
import com.example.repasoparcial.data.models.ProductModel
import com.example.repasoparcial.databinding.ProductItemBinding
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener

class ProductRecycleViewHolder(private val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(product: ProductModel, clickListener: (ProductModel) -> Unit) {
        binding.nameProduct.text = product.name
        binding.userProduct.text = product.user
        binding.priceProduct.text = product.price

        binding.productCard.setOnClickListener{
            clickListener(product)
        }
    }
}