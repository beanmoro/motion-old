package com.example.motionapp.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionapp.R
import com.example.motionapp.data.models.User
import com.example.motionapp.databinding.ActivityRegisterBinding
import com.example.motionapp.ui.register.fragments.RegisterFirstFragment
import com.example.motionapp.ui.register.fragments.RegisterSecondFragment
import com.example.motionapp.ui.register.fragments.RegisterSuccessFragment
import com.example.motionapp.ui.register.fragments.RegisterThirdFragment
import com.example.motionapp.utils.*

class RegisterActivity : AppCompatActivity(), RegisterContract.View, RegisterFirstFragment.Delegate, RegisterSecondFragment.Delegate, RegisterThirdFragment.Delegate, RegisterSuccessFragment.Delegate {

    lateinit var binding: ActivityRegisterBinding
    lateinit var mPresenter : RegisterContract.Presenter

    lateinit var registerFirstFragment : RegisterFirstFragment
    lateinit var registerSecondFragment : RegisterSecondFragment
    lateinit var registerThirdFragment : RegisterThirdFragment
    lateinit var registerSuccessFragment : RegisterSuccessFragment

    var currentFrag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.materialToolbar)

        //binding.materialToolbar.setNavigationOnClickListener {
        //    onBackPressed()
        //}
        mPresenter = RegisterWrapper.inject(this)

        registerFirstFragment = RegisterFirstFragment.newInstance()
        registerFirstFragment.delegate = this
        registerSecondFragment = RegisterSecondFragment.newInstance()
        registerSecondFragment.delegate = this
        registerThirdFragment = RegisterThirdFragment.newInstance()
        registerThirdFragment.delegate = this
        registerSuccessFragment = RegisterSuccessFragment.newInstance()
        registerSuccessFragment.delegate = this

        replaceFragment(registerFirstFragment, R.id.register_fragment_container){

        }
    }

    override fun BacktoFirstFragment() {
        replaceFragment(registerFirstFragment,R.id.register_fragment_container){
            fromLeftToRight()
        }
        currentFrag = 0
    }

    override fun ForwardtoSecondFragment() {
        replaceFragment(registerSecondFragment,R.id.register_fragment_container){
            fromRightToLeft()
        }
        currentFrag = 1
    }

    override fun ForwardtoThirdFragment() {
        replaceFragment(registerThirdFragment,R.id.register_fragment_container){
            fromRightToLeft()
        }
        currentFrag = 2
    }

    override fun BacktoSecondFragment() {
        replaceFragment(registerSecondFragment,R.id.register_fragment_container){
            fromLeftToRight()
        }
        currentFrag = 1
    }

    override fun ForwardtoSuccessFragment() {
        replaceFragment(registerSuccessFragment,R.id.register_fragment_container){
            fromRightToLeft()
        }
        currentFrag = 3
    }




    override fun saveData() {

        val bitmap = registerThirdFragment.avatar!!
        val user = User(registerFirstFragment.rut!!, registerSecondFragment.nombre, registerSecondFragment.apellido, registerSecondFragment.email, registerSecondFragment.password, bitmap.toBase64())
        /*try {
            FilesTools.saveBitmap(registerThirdFragment.avatar!!, "avatar", "imgs")



        }catch (e : Exception){
            Log.e("MotionApp", "ERROR: ${e.message}")
        }*/
        mPresenter.saveUser(user)
    }

    override fun onBackPressed() {
        if(currentFrag > 0  && currentFrag < 3){
            when(currentFrag){
                1 -> BacktoFirstFragment()
                2 -> BacktoSecondFragment()
            }
        }else{
            finish()
        }
    }

    override fun successRegister() {
        finish()
    }

}