package com.example.motionapp.ui.login

import com.example.motionapp.data.models.User

interface LoginContract {

    interface View {
        fun onDestroy()
        fun showToast(message : String)
        fun canRememberUser(user : User)
    }

    interface Presenter {
        fun toRegisterActivity()
        fun toRecoveryActivity()
        fun toHomeActivity()
        fun onDestroy()
        fun rememberUser()
        fun login(user : User)
    }

    interface Interactor {
        fun unRegister()
        fun login(user : User)
        fun rememberUser()
    }

    interface InteractorOutput {
        fun successfulLogin()
        fun failedLogin()
        fun canRememberUser(user : User)

    }

    interface Router {
        fun unRegister()
        fun presentRegister()
        fun presentRecovery()
        fun presentHome()

    }
}