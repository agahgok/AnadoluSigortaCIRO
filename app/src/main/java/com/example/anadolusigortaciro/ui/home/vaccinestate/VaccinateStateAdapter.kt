package com.example.anadolusigortaciro.ui.home.vaccinestate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.model.FoodCalendarData
import com.example.anadolusigortaciro.model.VaccineStateData

class VaccinateStateAdapter(
    val context: Context,
    val list: ArrayList<VaccineStateData>
    ) : RecyclerView.Adapter<VaccinateStateAdapter.VaccineStateViewHolder>() {

    inner class VaccineStateViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){
            val currentItem = list[position]
            val topic : TextView = itemView.findViewById(R.id.tvVaccineStateTopic)
            val content : TextView = itemView.findViewById(R.id.tvVaccineStateNote)
            val dateAndTime : TextView = itemView.findViewById(R.id.tvVaccineStateDateAndTime)

            topic.text = currentItem.topic
            content.text = currentItem.content
            dateAndTime.text = currentItem.dateAndTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineStateViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.item_vaccination_state_card,
            parent,
            false
        )
        return VaccineStateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VaccineStateViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}