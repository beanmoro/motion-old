package com.example.motionapp.ui.evaluations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionapp.databinding.ActivityProfileEvaluationsBinding

class EvaluationsActivity : AppCompatActivity(), EvaluationsContract.View {

    lateinit var mPresenter : EvaluationsContract.Presenter
    lateinit var binding : ActivityProfileEvaluationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileEvaluationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = EvaluationsWrapper.inject(this)

        binding.backArrow.setOnClickListener {
            finish()
        }
    }
}