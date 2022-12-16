package com.example.motionapp.ui.register

import android.util.Log
import com.example.motionapp.data.models.User
import com.orhanobut.hawk.Hawk

class RegisterInteractor : RegisterContract.Interactor{

    lateinit var mOutput : RegisterContract.InteractorOutput

    override fun saveUser(user: User) {
        if(Hawk.contains("user")){
            Hawk.delete("user")
        }
        Hawk.put("user", user)
        Log.d("MotionApp", "Saving data... \n${user} saved!")
    }

}