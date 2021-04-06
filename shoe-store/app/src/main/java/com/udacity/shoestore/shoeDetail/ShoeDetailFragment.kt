package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewModel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailBinding
    private val viewModel : ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        viewModel.makeNewShoe()
        binding.shoe = viewModel.newShoe
        binding.buttonSave.setOnClickListener { view : View ->
            viewModel.add(viewModel.newShoe)
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.buttonCancel.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }
}