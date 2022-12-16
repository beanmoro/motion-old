package com.example.motionapp.ui.register

object RegisterWrapper {

    fun inject(view : RegisterContract.View) : RegisterContract.Presenter {
        val presenter = RegisterPresenter()
        val router = RegisterRouter()
        val interactor = RegisterInteractor()

        interactor.mOutput = presenter

        presenter.mInteractor = interactor
        presenter.mView = view
        presenter.mRouter = router

        return presenter
    }
}