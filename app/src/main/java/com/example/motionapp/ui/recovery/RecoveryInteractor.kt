package com.example.motionapp.ui.recovery

import com.example.motionapp.data.models.User
import com.orhanobut.hawk.Hawk

class RecoveryInteractor : RecoveryContract.Interactor {

    lateinit var mOutput : RecoveryContract.InteractorOutput


    override fun recoverPassword(email: String) {

        if(Hawk.contains("user")){
            val usr = Hawk.get<User>("user")
            if(usr.email == email){
                mOutput.successfulRecover(usr.password)
                return
            }
        }
        mOutput.failedRecover()
    }
}