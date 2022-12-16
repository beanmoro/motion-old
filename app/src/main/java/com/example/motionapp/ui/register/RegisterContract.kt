package com.example.motionapp.ui.register

import com.example.motionapp.data.models.User

interface RegisterContract {

    interface View {

    }

    interface Presenter {
        fun saveUser(user : User)
    }

    interface Interactor {
        fun saveUser(user : User)
    }

    interface InteractorOutput {

    }

    interface Router {

    }
}