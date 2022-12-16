package com.example.motionapp.ui.edit_profile

import android.app.Activity

object EditProfileWrapper {

    fun inject(view : EditProfileContract.View) : EditProfileContract.Presenter {
        val presenter = EditProfilePresenter()
        val interactor = EditProfileInteractor()
        val router = EditProfileRouter()

        interactor.mOutput = presenter
        router.mActivity = view as Activity

        presenter.mInteractor = interactor
        presenter.mView = view
        presenter.mRouter = router

        return presenter
    }

}