package com.example.motionapp.ui.login

import android.app.Activity

object LoginWrapper {

    fun inject(view : LoginContract.View) : LoginContract.Presenter {
        val presenter = LoginPresenter()
        val router = LoginRouter()
        val interactor = LoginInteractor()

        interactor.mOutput = presenter
        router.mActivity = view as Activity

        presenter.mInteractor = interactor
        presenter.mView = view
        presenter.mRouter = router

        return presenter
    }
}