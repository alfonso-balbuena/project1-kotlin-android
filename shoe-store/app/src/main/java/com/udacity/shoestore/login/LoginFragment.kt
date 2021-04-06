package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        val view : View = binding.root
        binding.buttonLogin.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.buttonNewAccount.setOnClickListener { view : View -> view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)}
        return view
    }


}