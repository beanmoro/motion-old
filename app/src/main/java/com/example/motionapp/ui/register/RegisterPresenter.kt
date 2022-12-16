package com.example.motionapp.ui.register

import com.example.motionapp.data.models.User

class RegisterPresenter : RegisterContract.Presenter, RegisterContract.InteractorOutput {

    lateinit var mView : RegisterContract.View
    lateinit var mInteractor : RegisterContract.Interactor
    lateinit var mRouter : RegisterContract.Router

    override fun saveUser(user: User) {
        mInteractor.saveUser(user)
    }
}