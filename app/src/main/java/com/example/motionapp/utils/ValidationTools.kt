package com.example.motionapp.utils

import android.util.Log
import java.lang.Exception

class ValidationTools {

    companion object{
        fun rutValidate(rut : String) : Boolean{
            var _rut = rut
            var validation : Boolean = false
            try{

                _rut = _rut.uppercase()
                _rut = _rut.replace(".","")
                _rut = rut.replace("-","")
                var rutAux : Int = Integer.parseInt(_rut.substring(0,_rut.length - 1))

                var dv : Char = _rut[_rut.length-1]

                var m : Int = 0
                var s : Int = 1
                while (rutAux != 0){
                    s = (s + rutAux % 10 * (9 - m++ % 6)) % 11
                    rutAux /= 10
                }

                if(dv.uppercaseChar() == ( if (s != 0) (s + 47) else 75 ).toChar() ){
                    validation = true
                }
            }catch (e : Exception){
            }
            Log.d("MotionApp", "Es valido el Rut? ${validation}")
            return validation
        }
    }
}