package com.example.motionapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentMainScheduleBinding

class MainScheduleFragment : Fragment() {

    var _binding : FragmentMainScheduleBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainScheduleBinding.inflate(inflater, container, false)

        return binding.root
    }

}