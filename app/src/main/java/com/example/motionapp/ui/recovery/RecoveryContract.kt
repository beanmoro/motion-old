package com.example.motionapp.ui.recovery

import com.example.motionapp.data.models.User

interface RecoveryContract {

    interface View {
        fun showToast(message : String)
    }

    interface Presenter {
        fun recoverPassword( email : String)
    }

    interface Interactor {
        fun recoverPassword( email : String)

    }

    interface InteractorOutput {
        fun successfulRecover(pass : String)
        fun failedRecover()

    }

    interface Router {

    }
}