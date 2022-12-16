package com.example.motionapp.ui.recovery

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motionapp.databinding.ActivityRecoverBinding

class RecoveryActivity : AppCompatActivity(), RecoveryContract.View {

    lateinit var binding : ActivityRecoverBinding
    lateinit var mPresenter : RecoveryContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecoverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = RecoveryWrapper.inject(this)

        binding.backArrow.setOnClickListener {
            finish()
        }

        binding.doneButton.setOnClickListener {

            if (binding.emailRecoveryEti.text!!.toString().trim().length > 0){
                mPresenter.recoverPassword(binding.emailRecoveryEti.text!!.toString().trim())
            }
        }

    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}