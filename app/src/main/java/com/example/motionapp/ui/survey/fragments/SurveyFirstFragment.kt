package com.example.motionapp.ui.survey.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentSurvey1Binding

class SurveyFirstFragment : Fragment(){

    var _binding : FragmentSurvey1Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSurvey1Binding.inflate(inflater,  container, false)

        return binding.root
    }
}