package com.example.motionapp.utils

import android.graphics.Bitmap
import android.os.Environment
import java.io.File
import java.io.FileOutputStream

class FilesTools {

    companion object{

        fun saveBitmap(bitmap : Bitmap, filename : String, _filepath : String){

            val filepath : String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath + "/" + _filepath
            val dir = File(filepath)
            if(!dir.exists()){
                dir.mkdirs()
            }
            val file = File(dir, "${filename}.png")
            val fOut = FileOutputStream(file)

            bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut)
            fOut.flush()
            fOut.close()
        }
    }
}