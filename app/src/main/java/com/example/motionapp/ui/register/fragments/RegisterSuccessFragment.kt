package com.example.motionapp.ui.register.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentRegisterSuccessBinding

class RegisterSuccessFragment : Fragment() {

    var _binding : FragmentRegisterSuccessBinding? = null
    val binding get() = _binding!!
    var delegate : Delegate? = null

    interface Delegate {
        fun successRegister()
    }

    companion object{
        fun newInstance() : RegisterSuccessFragment = RegisterSuccessFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.doneButton.setOnClickListener {
            delegate!!.successRegister()
        }

    }


}