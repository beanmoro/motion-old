package com.example.motionapp.ui.login

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.motionapp.ui.home.HomeActivity
import com.example.motionapp.ui.recovery.RecoveryActivity
import com.example.motionapp.ui.register.RegisterActivity

class LoginRouter : LoginContract.Router {

    lateinit var mActivity : Activity
    override fun unRegister() {
        TODO("Not yet implemented")
    }

    override fun presentRegister() {
        val intent = Intent(mActivity, RegisterActivity::class.java)
        mActivity.startActivity(intent)
    }

    override fun presentRecovery() {
        val intent = Intent(mActivity, RecoveryActivity::class.java)
        mActivity.startActivity(intent)
    }

    override fun presentHome() {
        val intent = Intent(mActivity, HomeActivity::class.java)
        mActivity.startActivity(intent)
        mActivity.finish()
    }


}