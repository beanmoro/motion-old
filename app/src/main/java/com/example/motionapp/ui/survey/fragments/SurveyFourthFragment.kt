package com.example.motionapp.ui.survey.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentSurvey4Binding

class SurveyFourthFragment : Fragment() {

    var _binding : FragmentSurvey4Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSurvey4Binding.inflate(inflater, container, false)
        return binding.root
    }
}