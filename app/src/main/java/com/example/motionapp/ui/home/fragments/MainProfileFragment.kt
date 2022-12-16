package com.example.motionapp.ui.home.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.motionapp.R
import com.example.motionapp.data.models.User
import com.example.motionapp.databinding.FragmentMainProfileBinding
import com.example.motionapp.utils.toBitmap
import com.example.motionapp.utils.toFormattedRut

class MainProfileFragment : Fragment() {

    var _binding : FragmentMainProfileBinding? = null
    val binding get() = _binding!!
    var user : User? = null
    var delegate : Delegate? = null


    interface Delegate {
        fun logout()
        fun editProfile()
        fun changeAvatar()
        fun debt()
        fun evaluations()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainProfileBinding.inflate(inflater, container, false)

        val avatar = user!!.avatar.toBitmap()
        try {
            Glide.with(this).load(avatar).circleCrop().into(binding.userAvatar)
            binding.userFirstName.text = user!!.nombre
            binding.userLastname.text = user!!.apellido
            binding.userRut.text = user!!.rut.toFormattedRut()
        }catch (e : Exception){
            Log.e("MotionApp", "ERROR: ${e.message}")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutText.setOnClickListener {

            delegate!!.logout()

        }

        binding.editProfileText.setOnClickListener {

            delegate!!.editProfile()
        }

        binding.cameraBtn.setOnClickListener {

            delegate!!.changeAvatar()
        }

        binding.debtBtn.setOnClickListener {
            delegate!!.debt()
        }

        binding.evaluationsBtn.setOnClickListener {
            delegate!!.evaluations()
        }

    }
}