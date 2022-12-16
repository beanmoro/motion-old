package com.example.motionapp.ui.change_avatar

import android.graphics.Bitmap

class ChangeAvatarPresenter : ChangeAvatarContract.Presenter, ChangeAvatarContract.InteractorOuput {

    lateinit var mView : ChangeAvatarContract.View
    lateinit var mInteractor: ChangeAvatarContract.Interactor
    lateinit var mRouter : ChangeAvatarContract.Router

    override fun setAvatar(avatar: Bitmap) {
        mInteractor.setAvatar(avatar)
    }

    override fun toHomeActivity() {
        mRouter.presentHome()
    }

    override fun avatarChangedSuccessfully() {


    }

    override fun avatarChangeFailed() {
        mView.showToast("ERROR: No se pudo obtener avatar!")
    }
}