package com.example.motionapp.ui.register.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentRegister1Binding
import com.example.motionapp.utils.ValidationTools
import java.lang.Exception

class RegisterFirstFragment : Fragment() {

    var _binding : FragmentRegister1Binding? = null
    val binding get() = _binding!!
    var delegate : Delegate? = null

    var rut : String? = null

    interface Delegate {
        fun ForwardtoSecondFragment()
    }

    companion object{
        fun newInstance() : RegisterFirstFragment = RegisterFirstFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegister1Binding.inflate(inflater, container, false)
        binding.doneButton.visibility = View.INVISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rutEti.addTextChangedListener {
            if(!it!!.isNullOrBlank() && ValidationTools.rutValidate(it.toString())){
                rut = it.toString().trim()
                binding.doneButton.visibility = View.VISIBLE
            }
        }

        binding.backArrow.setOnClickListener {
            activity?.finish()
        }

        binding.doneButton.setOnClickListener {

            delegate!!.ForwardtoSecondFragment()
        }
    }


    /*fun rutValidate(rut : String) : Boolean{
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
    }*/
}