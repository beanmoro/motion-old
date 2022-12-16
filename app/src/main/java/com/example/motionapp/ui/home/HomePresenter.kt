package com.example.motionapp.ui.home

import android.util.Log
import com.example.motionapp.data.models.User

class HomePresenter : HomeContract.Presenter, HomeContract.InteractorOutput {

    lateinit var mView : HomeContract.View
    lateinit var mInteractor : HomeContract.Interactor
    lateinit var mRouter : HomeContract.Router

    override fun loadUser() {
        mInteractor.loadUser()
    }

    override fun toLoginActivity() {
        mRouter.presentLogin()
    }

    override fun toEditProfileActivity() {
        mRouter.presentEditProfile()
    }

    override fun toChangeAvatar() {
        mRouter.presentChangeAvatar()
    }

    override fun toDebtActivity() {
        mRouter.presentDebt()
    }

    override fun toEvaluationsActivity() {
        mRouter.presentEvaluations()
    }

    override fun logout() {
        mInteractor.logout()
    }

    override fun succesfulUserLoad(user: User) {
        mView.loadUser(user)
        Log.d("MotionApp", "${user}")
    }

    override fun failedUserLoad() {
        mView.showToast("ERROR: No se pudo cargar la informacion del usuario!")
    }

}