package com.example.motionapp.ui.home

import com.example.motionapp.data.models.User

interface HomeContract {

    interface View {
        fun loadUser(user : User)
        fun showToast(message : String)
    }

    interface Presenter {
        fun loadUser()
        fun toLoginActivity()
        fun toEditProfileActivity()
        fun toChangeAvatar()
        fun toDebtActivity()
        fun toEvaluationsActivity()
        fun logout()

    }

    interface Interactor {
        fun loadUser()
        fun logout()

    }

    interface InteractorOutput {
        fun succesfulUserLoad( user : User)
        fun failedUserLoad()

    }

    interface Router {
        fun presentLogin()
        fun presentEditProfile()
        fun presentChangeAvatar()
        fun presentDebt()
        fun presentEvaluations()
    }
}