package com.example.motionapp.ui.evaluations

class EvaluationsPresenter : EvaluationsContract.Presenter, EvaluationsContract.InteractorOutput {

    lateinit var mView : EvaluationsContract.View
    lateinit var mInteractor: EvaluationsContract.Interactor
    lateinit var mRouter: EvaluationsContract.Router


}