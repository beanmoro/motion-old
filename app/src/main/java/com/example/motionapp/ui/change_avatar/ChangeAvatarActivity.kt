package com.example.motionapp.ui.change_avatar

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.motionapp.databinding.ActivityChangeAvatarBinding
import com.example.motionapp.ui.global_fragments.PhotoDialogFragment

class ChangeAvatarActivity : AppCompatActivity(), ChangeAvatarContract.View, PhotoDialogFragment.Delegate{

    lateinit var mPresenter: ChangeAvatarContract.Presenter
    lateinit var binding : ActivityChangeAvatarBinding
    lateinit var photoDialogFragment: PhotoDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeAvatarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = ChangeAvatarWrapper.inject(this)
        photoDialogFragment = PhotoDialogFragment()

        binding.backArrow.setOnClickListener {

            finish()
        }

        binding.doneButton.visibility = View.INVISIBLE

        binding.photoButton.setOnClickListener {

            photoDialogFragment.delegate = this
            photoDialogFragment.show(supportFragmentManager, "PhotoSourceDialog")
        }

        binding.doneButton.setOnClickListener {
            val avatar = photoDialogFragment.avatar
            if(avatar != null){
                mPresenter.setAvatar(avatar)
                mPresenter.toHomeActivity()
            }
        }
    }

    override fun setPhoto(_avatar: Bitmap) {
        Glide.with(this).load(_avatar).circleCrop().into(binding.photoButton)
        binding.doneButton.show()
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


}