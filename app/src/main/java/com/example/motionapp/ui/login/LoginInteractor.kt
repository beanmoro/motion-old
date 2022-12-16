package com.example.motionapp.ui.login

import com.example.motionapp.data.models.User
import com.orhanobut.hawk.Hawk

class LoginInteractor : LoginContract.Interactor {

    lateinit var mOutput : LoginContract.InteractorOutput
    override fun unRegister() {
        TODO("Not yet implemented")
    }

    override fun login(user: User) {

        val loadedUser = Hawk.get<User>("user")

        if(user.email == loadedUser.email && user.password == loadedUser.password){
            mOutput.successfulLogin()
            if(Hawk.get<Boolean>("logged") != true){
                Hawk.put("logged", true)
            }
        }else{
            mOutput.failedLogin()
        }
    }

    override fun rememberUser() {
        if(Hawk.contains("logged") && Hawk.get<Boolean>("logged")){
            mOutput.canRememberUser(Hawk.get<User>("user"))
        }
    }
}