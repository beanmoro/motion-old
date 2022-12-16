package com.example.motionapp.ui.debt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.motionapp.R
import com.example.motionapp.databinding.DebtCardBinding

class DebtAdapter : RecyclerView.Adapter<DebtAdapter.DebtViewHolder>() {


    inner class DebtViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val binding = DebtCardBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.debt_card, parent, false)
        return DebtViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {

        if(position == 0){
            holder.binding.debtName.setText("1 GATORADE COOL BLUE")
        }else{
            holder.binding.debtName.setText("1 GATORADE MANZANA")
        }

        holder.binding.debtMoney.setText("$1.750")
    }

    override fun getItemCount(): Int = 2
}