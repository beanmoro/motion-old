package com.example.motionapp.ui.change_avatar

import android.graphics.Bitmap
import com.example.motionapp.data.models.User
import com.example.motionapp.utils.toBase64
import com.orhanobut.hawk.Hawk

class ChangeAvatarInteractor : ChangeAvatarContract.Interactor {

    lateinit var mOutput : ChangeAvatarContract.InteractorOuput

    override fun setAvatar(avatar: Bitmap) {

        val avatar_string = avatar.toBase64()

        if(Hawk.contains("user")){
            val oldUser = Hawk.get<User>("user")
            oldUser.avatar = avatar_string
            Hawk.delete("user")
            Hawk.put("user", oldUser)
            mOutput.avatarChangedSuccessfully()
        }else{
            mOutput.avatarChangeFailed()
        }

    }
}