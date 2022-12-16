package com.example.motionapp.ui.change_avatar

import android.app.Activity
import android.content.Intent
import com.example.motionapp.ui.home.HomeActivity

class ChangeAvatarRouter : ChangeAvatarContract.Router {

    lateinit var mActivity: Activity

    override fun presentHome() {
        val intent = Intent(mActivity, HomeActivity::class.java)
        intent.putExtra("fragment", 3)
        mActivity.startActivity(intent)
    }
}