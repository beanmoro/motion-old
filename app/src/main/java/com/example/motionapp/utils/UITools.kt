package com.example.motionapp.utils

import android.graphics.*
import android.os.Build
import androidx.annotation.RequiresApi

class UITools {

    companion object{
        //TODO: Eliminar Funcion por no uso!
        /*@RequiresApi(Build.VERSION_CODES.Q)
        fun getCroppedBitmap(bitmap : Bitmap) : Bitmap {
            var output = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
            var canvas = Canvas(output)

            //val color : Long = Color.WHITE
            val paint = Paint()
            val rect = Rect(0,0, bitmap.width, bitmap.height)

            paint.flags = Paint.ANTI_ALIAS_FLAG
            canvas.drawARGB(0,0,0,0)
            paint.setColor(Color.WHITE)
            canvas.drawCircle((bitmap.width / 2).toFloat(),
                (bitmap.height / 2).toFloat(), (bitmap.width / 2).toFloat(), paint)
            paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))
            canvas.drawBitmap(bitmap, rect, rect, paint)
            return output
        }*/
    }
}