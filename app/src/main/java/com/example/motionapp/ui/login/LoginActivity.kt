package com.example.motionapp.ui.login

import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motionapp.R
import com.example.motionapp.data.models.User
import com.example.motionapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var binding: ActivityLoginBinding
    lateinit var mPresenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MotionApp)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = LoginWrapper.inject(this)

        mPresenter.rememberUser()

        binding.button.setOnClickListener {
            val email = binding.emailLoginEti.text!!.toString().trim()
            val password = binding.passwordLoginEti.text!!.toString().trim()

            mPresenter.login(User("", "", "", email, password, ""))
        }

        binding.registerText.setOnClickListener {

            mPresenter.toRegisterActivity()

        }

        binding.recoveryTextView.setOnClickListener {
            mPresenter.toRecoveryActivity()
        }

        binding.passwordLoginEti.setOnEditorActionListener { _, i, _ ->

            when(i){

                EditorInfo.IME_ACTION_DONE -> binding.button.performClick()
            }


            true

        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun canRememberUser(user: User) {
        binding.emailLoginEti.setText(user.email)
        binding.passwordLoginEti.setText(user.password)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }
}