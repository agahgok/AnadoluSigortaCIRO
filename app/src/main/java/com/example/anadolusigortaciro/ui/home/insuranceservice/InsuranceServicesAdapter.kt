package com.example.anadolusigortaciro.ui.home.insuranceservice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.model.InsuranceServiceModel

class InsuranceServicesAdapter(
    private val context : Context,
    private val insuranceServiceList: List<InsuranceServiceModel>,
    var onInsuranceServiceClickListener : OnInsuranceServiceClickListener
) : RecyclerView.Adapter<InsuranceServicesAdapter.InsuranceServiceViewHolder>() {

    inner class InsuranceServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){
            val currentItem = insuranceServiceList[adapterPosition]
            val insuranceServiceImage: ImageView = itemView.findViewById(R.id.imInsuranceServiceCard)
            val insuranceServiceName: TextView = itemView.findViewById(R.id.tvInsuranceServiceName)

            insuranceServiceImage.setImageResource(currentItem.imageResource)
            insuranceServiceName.text = currentItem.serviceName

            itemView.setOnClickListener {
                onInsuranceServiceClickListener.onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuranceServiceViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.insurance_service_card_item,
            parent, false
        )
        return InsuranceServiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InsuranceServiceViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return insuranceServiceList.size
    }

    interface OnInsuranceServiceClickListener{
        fun onClick(position : Int)
    }
}