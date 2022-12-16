package com.example.motionapp.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.motionapp.R
import java.io.ByteArrayOutputStream
import java.text.NumberFormat

fun Bitmap.toBase64() : String{

    val baos = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val b = baos.toByteArray()
    return Base64.encodeToString(b, Base64.NO_WRAP)
}

fun String.toBitmap(): Bitmap {

    var avatar : Bitmap? = null
    try {
        val imageBytes = Base64.decode(this, 0)
        avatar = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }catch (e : Exception){
        Log.e("MotionApp", "ERROR : ${e.message}")
    }
    return avatar!!
}

inline fun FragmentManager.transaction(func : FragmentTransaction. () -> FragmentTransaction){
    beginTransaction().func().commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, func: FragmentTransaction.() -> Unit){
    supportFragmentManager.transaction {
        func()
        replace(frameId, fragment)
    }
}

fun FragmentTransaction.fromRightToLeft() : FragmentTransaction{
    return this.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
}

fun FragmentTransaction.fromLeftToRight() : FragmentTransaction{
    return this.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
}

fun String.toFormattedRut() : String {

    val clean = replace(".", "").replace("-", "")
    return if (clean.length > 1) {
        "${clean.substring(0, clean.lastIndex).numberFormatted()}-${clean.last()}"
    } else {
        clean
    }
}

fun String.numberFormatted(): String {
    return NumberFormat.getNumberInstance().format(this.toInt()).replace(",", ".")
}