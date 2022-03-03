package com.example.anadolusigortaciro.ui.home.calendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.model.FoodCalendarData

class FeedCalendarAdapter(
    private val context : Context,
    private val list : ArrayList<FoodCalendarData>
) : RecyclerView.Adapter<FeedCalendarAdapter.FeedCalendarViewHolder>() {

    inner class FeedCalendarViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){
            val currentItem = list[position]
            val topic : TextView = itemView.findViewById(R.id.tvFoodCalendarTopic)
            val content : TextView = itemView.findViewById(R.id.tvFoodCalendarNote)
            val dateAndTime : TextView = itemView.findViewById(R.id.tvFoodCalendarDateAndTime)

            topic.text = currentItem.topic
            content.text = currentItem.content
            dateAndTime.text = currentItem.dateAndTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedCalendarViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.item_food_calendar_card,
            parent,
            false
        )
        return FeedCalendarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FeedCalendarViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}