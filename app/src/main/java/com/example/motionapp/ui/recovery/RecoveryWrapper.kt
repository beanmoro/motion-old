package com.example.motionapp.ui.recovery

object RecoveryWrapper {

    fun inject(view : RecoveryContract.View) : RecoveryContract.Presenter{
        val presenter = RecoveryPresenter()
        val router = RecoveryRouter()
        val interactor = RecoveryInteractor()

        interactor.mOutput = presenter

        presenter.mInteractor = interactor
        presenter.mView = view
        presenter.mRouter = router

        return presenter
    }
}