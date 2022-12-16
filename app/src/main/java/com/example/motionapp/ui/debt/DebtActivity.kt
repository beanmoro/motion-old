package com.example.motionapp.ui.debt

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motionapp.databinding.ActivityDebtBinding
import com.example.motionapp.ui.debt.adapter.DebtAdapter

class DebtActivity : AppCompatActivity(), DebtContract.View {

    lateinit var mPresenter : DebtContract.Presenter
    lateinit var binding : ActivityDebtBinding
    lateinit var adapter : DebtAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDebtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = DebtWrapper.inject(this)

        adapter = DebtAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.backArrow.setOnClickListener {
            finish()
        }
    }
}