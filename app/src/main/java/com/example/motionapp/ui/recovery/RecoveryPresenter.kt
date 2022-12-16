package com.example.motionapp.ui.recovery

class RecoveryPresenter : RecoveryContract.Presenter, RecoveryContract.InteractorOutput {

    lateinit var mView : RecoveryContract.View
    lateinit var mInteractor : RecoveryContract.Interactor
    lateinit var mRouter : RecoveryContract.Router

    override fun recoverPassword(email: String) {
        mInteractor.recoverPassword(email)
    }

    override fun successfulRecover(pass : String) {
        mView.showToast("La contraseña es: ${pass}")
    }

    override fun failedRecover() {
        mView.showToast("No se encuentra un usuario vinculado a ese email!")
    }

}