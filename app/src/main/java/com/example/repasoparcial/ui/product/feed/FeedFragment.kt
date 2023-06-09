package com.example.repasoparcial.ui.product.feed

import android.content.AbstractThreadedSyncAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repasoparcial.R
import com.example.repasoparcial.data.models.ProductModel
import com.example.repasoparcial.databinding.FragmentFeedBinding
import com.example.repasoparcial.ui.product.feed.recycleview.ProductRecycleViewAdapter
import com.example.repasoparcial.ui.product.viewmodel.ProductViewModel

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private lateinit var adapter: ProductRecycleViewAdapter

    private val viewModel: ProductViewModel by activityViewModels {
        ProductViewModel.Factory
    }

    private fun showSelectedProduct(product: ProductModel) {
        viewModel.setSelectedProduct(product)
        findNavController().navigate(R.id.action_feedFragment_to_viewProductFragment)
    }

    private fun displayProducts(){
        adapter.setData(viewModel.getProducts())
        adapter.notifyDataSetChanged()
    }

    private fun setRecycleView(view: View){
        binding.productRecycleview.layoutManager = LinearLayoutManager(view.context)

        adapter = ProductRecycleViewAdapter { selectedProduct ->
            showSelectedProduct(selectedProduct)
        }

        binding.productRecycleview.adapter = adapter
        displayProducts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycleView(view)

        binding.actionToCreateProduct.setOnClickListener{
            viewModel.clearData()
            findNavController().navigate(R.id.action_feedFragment_to_newProductFragment)
        }
    }
}