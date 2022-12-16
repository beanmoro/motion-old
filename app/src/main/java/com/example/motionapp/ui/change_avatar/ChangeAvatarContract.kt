package com.example.motionapp.ui.change_avatar

import android.graphics.Bitmap

interface ChangeAvatarContract {

    interface View {
        fun showToast(msg : String)

    }

    interface Presenter {
        fun setAvatar(avatar : Bitmap)
        fun toHomeActivity()
    }

    interface Interactor {
        fun setAvatar(avatar : Bitmap)
    }

    interface InteractorOuput {
        fun avatarChangedSuccessfully()
        fun avatarChangeFailed()
    }

    interface Router {
        fun presentHome()
    }

}