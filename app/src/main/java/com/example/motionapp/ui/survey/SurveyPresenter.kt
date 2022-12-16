package com.example.motionapp.ui.survey

class SurveyPresenter : SurveyContract.Presenter, SurveyContract.InteractorOutput {

    lateinit var mView: SurveyContract.View
    lateinit var mInteractor : SurveyContract.Interactor
    lateinit var mRouter: SurveyContract.Router
}