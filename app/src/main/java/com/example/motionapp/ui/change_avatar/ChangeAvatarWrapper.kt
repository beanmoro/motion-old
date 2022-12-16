package com.example.motionapp.ui.change_avatar

import android.app.Activity

object ChangeAvatarWrapper {

    fun inject(view : ChangeAvatarContract.View) : ChangeAvatarContract.Presenter{
        val presenter = ChangeAvatarPresenter()
        val interactor = ChangeAvatarInteractor()
        val router = ChangeAvatarRouter()

        interactor.mOutput = presenter
        router.mActivity = view as Activity

        presenter.mView = view
        presenter.mInteractor = interactor
        presenter.mRouter = router

        return presenter
    }
}