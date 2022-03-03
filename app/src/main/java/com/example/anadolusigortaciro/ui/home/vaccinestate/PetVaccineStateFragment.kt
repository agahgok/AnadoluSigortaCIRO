package com.example.anadolusigortaciro.ui.home.vaccinestate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anadolusigortaciro.databinding.FragmentPetVaccineStateBinding
import com.example.anadolusigortaciro.model.FoodCalendarData
import com.example.anadolusigortaciro.model.VaccineStateData
import com.example.anadolusigortaciro.ui.home.calendar.FeedCalendarAdapter
import java.util.*
import kotlin.collections.ArrayList

class PetVaccineStateFragment : Fragment() {
    private lateinit var binding : FragmentPetVaccineStateBinding
    private val list = ArrayList<VaccineStateData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetVaccineStateBinding.inflate(inflater,container,false)

        setRecyclerViewAdapter(list)
        binding.btnVaccineStateSave.setOnClickListener {
            addTask()
        }
        return binding.root
    }

    private fun addTask(){
        val topic : String = binding.etVaccineStateTopic.text.toString()
        val content : String = binding.etVaccineStateContent.text.toString()
        val dateAndTime : String = getDateAndTime()

        val vaccineStateData = VaccineStateData(topic,content,dateAndTime)
        list.add(vaccineStateData)
        setRecyclerViewAdapter(list)
    }
    private fun setRecyclerViewAdapter(list : ArrayList<VaccineStateData>){
        val mLayoutManager = LinearLayoutManager(context)
        binding.recyclerViewPetVaccineState.layoutManager = mLayoutManager
        binding.recyclerViewPetVaccineState.adapter = context?.let {
            VaccinateStateAdapter(it,list)
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