package com.example.motionapp.ui.survey.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentSurveySuccessBinding

class SurveySuccessFragment : Fragment() {

    var _binding : FragmentSurveySuccessBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSurveySuccessBinding.inflate(inflater, container, false)
        return binding.root
    }
}