package com.example.motionapp.ui.evaluations

import android.app.Activity

object EvaluationsWrapper {

    fun inject(view : EvaluationsContract.View) : EvaluationsContract.Presenter {
        val presenter = EvaluationsPresenter()
        val interactor = EvaluationsInteractor()
        val router = EvaluationsRouter()

        interactor.mOutput = presenter
        router.mActivity = view as Activity

        presenter.mView = view
        presenter.mInteractor = interactor
        presenter.mRouter = router

        return presenter
    }
}