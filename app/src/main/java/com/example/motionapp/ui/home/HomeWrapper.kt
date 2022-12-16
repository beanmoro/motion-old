package com.example.motionapp.ui.home

import android.app.Activity

object HomeWrapper {

    fun inject(view : HomeContract.View) : HomeContract.Presenter{
        var presenter = HomePresenter()
        var interactor = HomeInteractor()
        var router = HomeRouter()

        interactor.mOutput = presenter
        router.mActivity = view as Activity

        presenter.mInteractor = interactor
        presenter.mView = view
        presenter.mRouter = router

        return presenter
    }
}