package com.example.repasoparcial.ui.product.newproduct

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.repasoparcial.R
import com.example.repasoparcial.databinding.FragmentNewProductBinding
import com.example.repasoparcial.ui.product.viewmodel.ProductViewModel


class NewProductFragment : Fragment() {

    private lateinit var binding: FragmentNewProductBinding

    private val viewModel: ProductViewModel by activityViewModels {
        ProductViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserver()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun setObserver() {
        viewModel.status.observe(viewLifecycleOwner){status ->
            when {
                status.equals(ProductViewModel.PRODUCT_CREATE) -> {
                    Log.d("TAG APP", status)
                    Log.d("TAG APP", viewModel.getProducts().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }
                status.equals(ProductViewModel.WRONG_DATA) -> {
                    Log.d("APP TAP", status)
                    viewModel.clearStatus()
                }
            }
        }
    }

}