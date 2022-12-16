package com.example.motionapp.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.motionapp.R
import com.example.motionapp.data.models.User
import com.example.motionapp.databinding.ActivityHomeBinding
import com.example.motionapp.ui.home.fragments.MainProfileFragment
import com.example.motionapp.ui.home.fragments.MainProgressFragment
import com.example.motionapp.ui.home.fragments.MainScheduleFragment
import com.example.motionapp.ui.home.fragments.MainSurveyFragment
import com.example.motionapp.utils.replaceFragment

class HomeActivity : AppCompatActivity(), HomeContract.View, MainProfileFragment.Delegate {

    lateinit var binding: ActivityHomeBinding
    lateinit var mPresenter: HomeContract.Presenter

    lateinit var mainScheduleFragment : MainScheduleFragment
    lateinit var mainProgressFragment : MainProgressFragment
    lateinit var mainProfileFragment: MainProfileFragment
    lateinit var mainSurveyFragment: MainSurveyFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = HomeWrapper.inject(this)

        mainScheduleFragment = MainScheduleFragment()
        mainProgressFragment = MainProgressFragment()
        mainSurveyFragment = MainSurveyFragment()
        mainProfileFragment = MainProfileFragment()
        mainProfileFragment.delegate = this

        mPresenter.loadUser()



        replaceFragment(mainScheduleFragment, R.id.home_fragment_container){
        }


        binding.bottomNavigation.setOnItemSelectedListener {
            var current_frag : Fragment? = null
            when(it.itemId){
                R.id.bn_schedule_item -> current_frag = mainScheduleFragment
                R.id.bn_progress_item -> current_frag = mainProgressFragment
                R.id.bn_survey_item -> current_frag = mainSurveyFragment
                R.id.bn_profile_item -> current_frag = mainProfileFragment
            }
            replaceFragment(current_frag!!, R.id.home_fragment_container){

            }
            true
        }

        val fragmentToShow = intent.getIntExtra("fragment", 0)

        if(fragmentToShow == 3) {
            binding.bottomNavigation.selectedItemId = R.id.bn_profile_item
        }else{
            binding.bottomNavigation.selectedItemId = R.id.bn_schedule_item
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun loadUser(user: User) {
        mainProfileFragment.user = user

    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun logout() {
        mPresenter.logout()
        mPresenter.toLoginActivity()
        //finish()
    }

    override fun editProfile() {
        mPresenter.toEditProfileActivity()
        finish()
    }

    override fun changeAvatar() {
        mPresenter.toChangeAvatar()
    }

    override fun debt() {
        mPresenter.toDebtActivity()
    }

    override fun evaluations() {

        mPresenter.toEvaluationsActivity()
    }


}

