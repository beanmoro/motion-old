package com.example.motionapp.ui.debt

import android.app.Activity

object DebtWrapper {

    fun inject(view : DebtContract.View) : DebtContract.Presenter {
        val presenter = DebtPresenter()
        val interactor = DebtInteractor()
        val router = DebtRouter()

        interactor.mOutput = presenter
        router.mActivity = view as Activity

        presenter.mView = view
        presenter.mInteractor = interactor
        presenter.mRouter = router
        return presenter
    }
}