package com.example.motionapp.ui.edit_profile

import com.example.motionapp.data.models.User
import com.example.motionapp.utils.ValidationTools
import com.orhanobut.hawk.Hawk

class EditProfileInteractor : EditProfileContract.Interactor {

    lateinit var mOutput : EditProfileContract.InteractorOutput
    override fun modifyUser(user: User) {

        val oldUser = Hawk.get<User>("user")

        if( oldUser.nombre != user.nombre ||
            oldUser.apellido != user.apellido ||
            oldUser.email != user.email ||
            oldUser.rut != user.rut
                ){
            Hawk.delete("user")
            Hawk.put("user", User(user.rut, user.nombre, user.apellido, user.email, oldUser.password, oldUser.avatar))
            mOutput.userModifiedSuccesfully()
        }else{
            mOutput.userModifiedFailed()
        }

    }

    override fun getUser(): User {
        return Hawk.get<User>("user")
    }


}