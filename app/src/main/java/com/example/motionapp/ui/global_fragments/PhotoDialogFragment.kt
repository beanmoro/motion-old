package com.example.motionapp.ui.global_fragments

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.motionapp.databinding.FragmentBottomPhotoSourceBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PhotoDialogFragment : BottomSheetDialogFragment() {

    var _binding : FragmentBottomPhotoSourceBinding? = null
    val binding get() = _binding!!

    var avatar : Bitmap? = null

    var delegate : Delegate? = null

    interface Delegate {
        fun setPhoto(_avatar : Bitmap)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomPhotoSourceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.photoGalleryBtn.setOnClickListener {
            val intent = Intent().setType("*/*").setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)
        }

        binding.photoCameraBtn.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 42)

        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 42 && resultCode == Activity.RESULT_OK){

            avatar = data?.extras?.get("data") as Bitmap


            delegate!!.setPhoto(avatar!!)
        }else if(requestCode == 111 && resultCode == Activity.RESULT_OK){
            val filePath = Uri.parse(data?.data.toString())
            avatar = MediaStore.Images.Media.getBitmap(context?.contentResolver, filePath)
            delegate!!.setPhoto(avatar!!)
        }else{
            Log.e("MotionApp", "ERROR: No se pudo cargar la foto!!")
        }

        dismiss()
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

    }
}