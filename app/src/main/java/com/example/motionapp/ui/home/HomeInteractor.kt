package com.example.motionapp.ui.home

import android.util.Log
import com.example.motionapp.data.models.User
import com.orhanobut.hawk.Hawk

class HomeInteractor : HomeContract.Interactor {

    lateinit var mOutput : HomeContract.InteractorOutput

    override fun loadUser() {
        if(Hawk.contains("user")){
            val usr = Hawk.get<User>("user")
            Log.d("MotionApp", "${usr}")
            mOutput.succesfulUserLoad(usr)
        }else{
            mOutput.failedUserLoad()
        }
    }

    override fun logout() {
        if(Hawk.contains("logged")){
            Hawk.delete("logged")
            Hawk.put("logged", false)
        }
    }
}