package com.example.motionapp.ui.debt

class DebtPresenter : DebtContract.Presenter, DebtContract.InteractorOutput{

    lateinit var mView : DebtContract.View
    lateinit var mInteractor: DebtContract.Interactor
    lateinit var mRouter : DebtContract.Router
}