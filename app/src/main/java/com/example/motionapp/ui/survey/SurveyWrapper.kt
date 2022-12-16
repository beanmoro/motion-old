package com.example.motionapp.ui.survey

import android.app.Activity

object SurveyWrapper {

    fun inject(view : SurveyContract.View) : SurveyContract.Presenter {
        val presenter = SurveyPresenter()
        val interactor = SurveyInteractor()
        val router = SurveyRouter()

        interactor.mOutput = presenter
        router.mActivity = view as Activity

        presenter.mView = view
        presenter.mInteractor = interactor
        presenter.mRouter = router

        return presenter
    }
}