package com.example.motionapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentMainSurveyBinding

class MainSurveyFragment : Fragment() {

    var _binding : FragmentMainSurveyBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainSurveyBinding.inflate(inflater, container, false)
        return binding.root
    }
}