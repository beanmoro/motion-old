package com.example.motionapp.ui.home

import android.app.Activity
import android.content.Intent
import com.example.motionapp.ui.change_avatar.ChangeAvatarActivity
import com.example.motionapp.ui.debt.DebtActivity
import com.example.motionapp.ui.edit_profile.EditProfileActivity
import com.example.motionapp.ui.evaluations.EvaluationsActivity
import com.example.motionapp.ui.login.LoginActivity

class HomeRouter : HomeContract.Router {

    lateinit var mActivity : Activity


    override fun presentLogin() {
        val intent = Intent(mActivity, LoginActivity::class.java)
        mActivity.startActivity(intent)
    }

    override fun presentEditProfile() {
        val intent = Intent(mActivity, EditProfileActivity::class.java)
        mActivity.startActivity(intent)
    }

    override fun presentChangeAvatar() {
        val intent = Intent(mActivity, ChangeAvatarActivity::class.java)
        mActivity.startActivity(intent)
    }

    override fun presentDebt() {
        val intent = Intent(mActivity, DebtActivity::class.java)
        mActivity.startActivity(intent)
    }

    override fun presentEvaluations() {
        val intent = Intent(mActivity, EvaluationsActivity::class.java)
        mActivity.startActivity(intent)
    }
}