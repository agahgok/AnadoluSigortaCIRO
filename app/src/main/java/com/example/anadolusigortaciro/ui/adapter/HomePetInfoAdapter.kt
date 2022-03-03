package com.example.anadolusigortaciro.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anadolusigortaciro.R


class HomePetInfoAdapter(
    val context : Context,
    val petInfoList : ArrayList<String>
) :RecyclerView.Adapter<HomePetInfoAdapter.HomePetInfoViewHolder>() {

    inner class HomePetInfoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){
            var currentItem = petInfoList[adapterPosition]
            val petInfoText : TextView = itemView.findViewById(R.id.tvPetInfo)
            petInfoText.text = currentItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePetInfoViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.home_pet_info_card,
        parent,false)
        return HomePetInfoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomePetInfoViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = petInfoList.size
}