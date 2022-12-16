package com.example.motionapp.ui.register.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.motionapp.databinding.FragmentRegister2Binding

class RegisterSecondFragment : Fragment() {

    var _binding : FragmentRegister2Binding? = null
    val binding get() = _binding!!
    var delegate : Delegate? = null
    var formComplete = false

    var nombre : String = ""
    var apellido : String = ""
    var email : String = ""
    var password : String = ""

    interface Delegate {
        fun BacktoFirstFragment()
        fun ForwardtoThirdFragment()
    }

    companion object{
        fun newInstance() : RegisterSecondFragment = RegisterSecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegister2Binding.inflate(inflater, container, false)
        binding.doneButton.visibility = View.INVISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nombreEti.addTextChangedListener{ showButtonVisibility() }
        binding.apellidoEti.addTextChangedListener{ showButtonVisibility() }
        binding.emailEti.addTextChangedListener{ showButtonVisibility() }
        binding.email2Eti.addTextChangedListener{ showButtonVisibility() }
        binding.passwordEti.addTextChangedListener{ showButtonVisibility() }
        binding.password2Eti.addTextChangedListener{ showButtonVisibility() }


        binding.backArrow.setOnClickListener {
            delegate!!.BacktoFirstFragment()
        }

        binding.doneButton.setOnClickListener {

            nombre = binding.nombreEti.text!!.toString().trim()
            apellido = binding.apellidoEti.text!!.toString().trim()
            email = binding.emailEti.text!!.toString().trim()
            password = binding.passwordEti.text!!.toString().trim()
            delegate!!.ForwardtoThirdFragment()
        }
    }


    fun isFormComplete() : Boolean{

        var formComplete = binding.nombreEti.text!!.toString().trim().length >= 4
                        && binding.apellidoEti.text!!.toString().trim().length >= 4
                        && binding.emailEti.text!!.toString().trim().length >= 16
                        && binding.email2Eti.text!!.toString().trim().length >= 16
                        && binding.passwordEti.text!!.toString().trim().length >= 6
                        && binding.password2Eti.text!!.toString().trim().length >= 6


        formComplete = formComplete && (binding.emailEti.text!!.toString().trim() == binding.email2Eti.text!!.toString().trim())
        formComplete = formComplete && (binding.passwordEti.text!!.toString().trim() == binding.password2Eti.text.toString()!!.trim())

        formComplete = formComplete
                        && android.util.Patterns.EMAIL_ADDRESS.matcher(binding.emailEti.text!!.toString()).matches()

        Log.d("MotionApp", "Valid email: ${android.util.Patterns.EMAIL_ADDRESS.matcher(binding.emailEti.text!!).matches()} ->FormComplete ${formComplete}")

        Log.d("MotionApp", " ${binding.emailEti.text!!.trim()} == ${binding.email2Eti.text!!.trim()} -> ${binding.emailEti.text!!.trim() == binding.email2Eti.text!!.trim()} && ${binding.passwordEti.text!!} == ${binding.password2Eti.text!!} -> ${binding.passwordEti.text!!.trim() == binding.password2Eti.text!!.trim()}")



        return formComplete
    }

    fun showButtonVisibility(){
        if(isFormComplete()){
            binding.doneButton.visibility = View.VISIBLE
        }else{
            binding.doneButton.visibility = View.INVISIBLE
        }
    }

}