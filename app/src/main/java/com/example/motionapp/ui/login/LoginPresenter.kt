package com.example.motionapp.ui.login

import com.example.motionapp.data.models.User

class LoginPresenter : LoginContract.Presenter, LoginContract.InteractorOutput {

    lateinit var mView : LoginContract.View
    lateinit var mInteractor : LoginContract.Interactor
    lateinit var mRouter : LoginContract.Router


    override fun toRegisterActivity() {
        mRouter.presentRegister()
    }

    override fun toRecoveryActivity() {
        mRouter.presentRecovery()
    }

    override fun toHomeActivity() {
        mRouter.presentHome()
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun rememberUser() {
        mInteractor.rememberUser()
    }

    override fun login(user: User) {
        mInteractor.login(user)
    }

    override fun successfulLogin() {
        toHomeActivity()
    }

    override fun failedLogin() {
        mView.showToast("Error al iniciar sesion: Datos Incorrectos!")
    }

    override fun canRememberUser(user : User) {
        mInteractor.login(user)
    }
}