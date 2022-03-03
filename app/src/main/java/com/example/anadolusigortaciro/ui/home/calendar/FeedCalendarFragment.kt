package com.example.anadolusigortaciro.ui.home.calendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anadolusigortaciro.databinding.FragmentFeedCalendarBinding
import com.example.anadolusigortaciro.model.FoodCalendarData
import java.util.*
import kotlin.collections.ArrayList

class FeedCalendarFragment : Fragment() {
    private lateinit var binding : FragmentFeedCalendarBinding
    private var list = ArrayList<FoodCalendarData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedCalendarBinding.inflate(layoutInflater,container,false)

        setRecyclerViewAdapter(list)
        binding.btnFeedCalendarSave.setOnClickListener {
            addTask()
        }
        return binding.root
    }

    private fun addTask(){
        val topic : String = binding.etFeedCalendarTopic.text.toString()
        val content : String = binding.etFeedCalendarContent.text.toString()
        val dateAndTime : String = getDateAndTime()

        val foodCalendarData = FoodCalendarData(topic,content,dateAndTime)
        list.add(foodCalendarData)
        setRecyclerViewAdapter(list)
    }
    private fun setRecyclerViewAdapter(list : ArrayList<FoodCalendarData>){
        val mLayoutManager = LinearLayoutManager(context)
        binding.recyclerViewFeedCalendar.layoutManager = mLayoutManager
        binding.recyclerViewFeedCalendar.adapter = context?.let {
            FeedCalendarAdapter(it,list)
        }
    }

    private fun getDateAndTime(): String{
        val minute = binding.timePicker.minute
        val hour = binding.timePicker.hour
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return setDateAndTime(calendar.timeInMillis)
    }

    private fun setDateAndTime(time: Long): String {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(requireContext())
        val timeFormat = android.text.format.DateFormat.getTimeFormat(requireContext())

        return dateFormat.format(date) + " " + timeFormat.format(date)
    }
}