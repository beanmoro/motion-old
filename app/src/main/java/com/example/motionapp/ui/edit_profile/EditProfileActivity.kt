package com.example.motionapp.ui.edit_profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motionapp.R
import com.example.motionapp.data.models.User
import com.example.motionapp.databinding.ActivityEditProfileBinding
import com.example.motionapp.ui.edit_profile.fragments.FragmentEditProfile1
import com.example.motionapp.ui.edit_profile.fragments.FragmentEditProfileSuccess
import com.example.motionapp.utils.fromLeftToRight
import com.example.motionapp.utils.fromRightToLeft
import com.example.motionapp.utils.replaceFragment

class EditProfileActivity  : AppCompatActivity(), EditProfileContract.View, FragmentEditProfile1.Delegate, FragmentEditProfileSuccess.Delegate{

    lateinit var mPresenter : EditProfileContract.Presenter
    lateinit var binding : ActivityEditProfileBinding

    lateinit var fragmentEditProfile1 : FragmentEditProfile1
    lateinit var fragmentEditProfileSuccess : FragmentEditProfileSuccess


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = EditProfileWrapper.inject(this)

        fragmentEditProfile1 = FragmentEditProfile1()
        fragmentEditProfile1.delegate = this
        fragmentEditProfileSuccess = FragmentEditProfileSuccess()
        fragmentEditProfileSuccess.delegate = this

        replaceFragment(fragmentEditProfile1, R.id.edit_profile_fragment_container){

        }






    }

    override fun getUser(): User {
        return mPresenter.getUser()
    }

    override fun setUser(user: User) {
        mPresenter.modifyUser(user)
    }

    override fun finishActivity() {
        mPresenter.toHomeActivity()
    }

    override fun toSuccessfulFragment() {
        replaceFragment(fragmentEditProfileSuccess, R.id.edit_profile_fragment_container){
            fromRightToLeft()
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun backToHome() {
        mPresenter.toHomeActivity()
        finish()
    }
}