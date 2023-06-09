package com.example.repasoparcial.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.repasoparcial.R
import com.example.repasoparcial.databinding.FragmentViewProductBinding
import com.example.repasoparcial.ui.product.viewmodel.ProductViewModel

class ViewProductFragment : Fragment() {

    private lateinit var binding: FragmentViewProductBinding

    private val viewModel : ProductViewModel by activityViewModels {
        ProductViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

}