package com.example.motionapp.ui.edit_profile

import com.example.motionapp.data.models.User

class EditProfilePresenter : EditProfileContract.Presenter, EditProfileContract.InteractorOutput {

    lateinit var mView : EditProfileContract.View
    lateinit var mInteractor : EditProfileContract.Interactor
    lateinit var mRouter : EditProfileContract.Router


    override fun modifyUser(user: User) {
        mInteractor.modifyUser(user)
    }

    override fun getUser(): User {
        return mInteractor.getUser()
    }

    override fun toHomeActivity() {
        mRouter.presentHome()

    }

    override fun userModifiedSuccesfully() {
        mView.toSuccessfulFragment()
    }

    override fun userModifiedFailed() {
        mView.showToast("No se pudo modificar el usuario!")
    }

}