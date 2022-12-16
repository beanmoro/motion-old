package com.example.motionapp.ui.register.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.example.motionapp.R
import com.example.motionapp.databinding.FragmentRegister3Binding
import com.example.motionapp.ui.global_fragments.PhotoDialogFragment
import com.example.motionapp.utils.FilesTools
import com.example.motionapp.utils.UITools

class RegisterThirdFragment : Fragment(), PhotoDialogFragment.Delegate {

    var _binding : FragmentRegister3Binding? = null
    val binding get() = _binding!!
    var delegate : Delegate? = null
    var avatar : Bitmap? = null

    val REQUEST_IMAGE_CAPTURE = 1
    var previewImage : Bitmap? = null

    lateinit var photoDialogFragment : PhotoDialogFragment

    interface Delegate {
        fun BacktoSecondFragment()
        fun ForwardtoSuccessFragment()
        fun saveData()
    }

    companion object{
        fun newInstance() : RegisterThirdFragment = RegisterThirdFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegister3Binding.inflate(inflater, container, false)


        photoDialogFragment = PhotoDialogFragment()
        photoDialogFragment.delegate = this


        binding.photoButton.setOnClickListener {

            photoDialogFragment.show(childFragmentManager, "PhotoSourceDialog")

        }

        binding.doneButton.visibility = View.INVISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.skipButton.setOnClickListener {
            delegate!!.saveData()
            delegate!!.ForwardtoSuccessFragment()
        }

        binding.backArrow.setOnClickListener {
            delegate!!.BacktoSecondFragment()
        }

        binding.doneButton.setOnClickListener {
            delegate!!.saveData()
            delegate!!.ForwardtoSuccessFragment()
        }
    }


    override fun setPhoto(_avatar: Bitmap) {
        avatar = _avatar
        Glide.with(this).load(avatar!!).circleCrop().into(binding.photoButton)
        binding.skipButton.visibility = View.INVISIBLE
        binding.doneButton.visibility = View.VISIBLE
    }


}