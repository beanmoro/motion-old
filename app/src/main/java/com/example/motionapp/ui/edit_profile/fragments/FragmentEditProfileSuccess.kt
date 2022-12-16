package com.example.motionapp.ui.edit_profile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentEditProfileSuccessBinding

class FragmentEditProfileSuccess : Fragment() {

    var _binding : FragmentEditProfileSuccessBinding? = null
    val binding get() = _binding!!
    var delegate : Delegate? = null

    interface Delegate {
        fun backToHome()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileSuccessBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.doneButton.setOnClickListener {
            delegate!!.backToHome()
        }
    }
}