package com.example.motionapp.ui.edit_profile

import com.example.motionapp.data.models.User

interface EditProfileContract {

    interface View{
        fun toSuccessfulFragment()
        fun showToast(message : String)
    }

    interface Presenter {
        fun modifyUser(user : User)
        fun getUser() : User
        fun toHomeActivity()
    }

    interface Interactor {
        fun modifyUser(user : User)
        fun getUser() : User
    }

    interface InteractorOutput {
        fun userModifiedSuccesfully()
        fun userModifiedFailed()
    }

    interface Router {
        fun presentHome()
    }
}