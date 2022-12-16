package com.example.motionapp.ui.edit_profile.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.motionapp.data.models.User
import com.example.motionapp.databinding.FragmentEditProfile1Binding
import com.example.motionapp.utils.ValidationTools

class FragmentEditProfile1 : Fragment() {

    var _binding : FragmentEditProfile1Binding? = null
    val binding get() = _binding!!
    var delegate : Delegate? = null

    interface Delegate {
        fun getUser() : User
        fun setUser(user : User)

        fun finishActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfile1Binding.inflate(inflater, container, false)

        val user = delegate!!.getUser()
        binding.nombreEti.setText(user.nombre)
        binding.apellidoEti.setText(user.apellido)
        binding.emailEti.setText(user.email)
        binding.rutEti.setText(user.rut)

        binding.doneButton.visibility = View.INVISIBLE

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nombreEti.addTextChangedListener { showButtonVisibility() }
        binding.apellidoEti.addTextChangedListener { showButtonVisibility() }
        binding.emailEti.addTextChangedListener { showButtonVisibility() }
        binding.rutEti.addTextChangedListener { showButtonVisibility() }

        binding.doneButton.setOnClickListener {
            val user = User( binding.rutEti.text!!.toString(), binding.nombreEti.text!!.toString(), binding.apellidoEti.text!!.toString(), binding.emailEti.text!!.toString())
            delegate!!.setUser(user)
        }

        binding.backArrow.setOnClickListener {
            delegate!!.finishActivity()
        }


    }

    fun isFormComplete() : Boolean{

        var formComplete = binding.nombreEti.text!!.toString().trim().length >= 4
                && binding.apellidoEti.text!!.toString().trim().length >= 4
                && binding.emailEti.text!!.toString().trim().length >= 16


        formComplete = formComplete
                && android.util.Patterns.EMAIL_ADDRESS.matcher(binding.emailEti.text!!.toString()).matches()


        return formComplete
    }

    fun showButtonVisibility(){
        if(isFormComplete() && ValidationTools.rutValidate(binding.rutEti.text!!.toString())){
            binding.doneButton.visibility = View.VISIBLE
        }else{
            binding.doneButton.visibility = View.INVISIBLE
        }
    }
}