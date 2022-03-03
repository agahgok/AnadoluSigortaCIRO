package com.example.anadolusigortaciro.ui.home

import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentHomeBinding
import com.example.anadolusigortaciro.ui.adapter.HomePetInfoAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val petInfoList = ArrayList<String>()
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setPetInfoList()
        setRecyclerViewAdapter()

        binding.layoutHomeCalendar.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_feedCalendarFragment)
        }
        binding.layoutHomeVaccineState.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_petVaccineStateFragment)
        }
        return binding.root
    }

    private fun setRecyclerViewAdapter() {
        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewHomePetInfo.layoutManager = mLayoutManager
        binding.recyclerViewHomePetInfo.adapter = context?.let {
            HomePetInfoAdapter(it, petInfoList)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.mapPetLocation) as SupportMapFragment?
        mapFragment?.getMapAsync {
            mMap = it
            val zoomLevel = 10f
            mMap.uiSettings.isZoomControlsEnabled = true

            val here = LatLng(40.96113591951732,29.190520150412876)
            mMap.addMarker(
                MarkerOptions().position(here).title("Burada")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.paw))
            )
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(here,zoomLevel))
        }
    }
    private fun setPetInfoList(){
        petInfoList.add(resources.getString(R.string.cat1))
        petInfoList.add(resources.getString(R.string.cat2))
        petInfoList.add(resources.getString(R.string.cat3))
        petInfoList.add(resources.getString(R.string.cat4))
        petInfoList.add(resources.getString(R.string.cat5))

        petInfoList.add(resources.getString(R.string.dog1))
        petInfoList.add(resources.getString(R.string.dog2))
        petInfoList.add(resources.getString(R.string.dog3))
        petInfoList.add(resources.getString(R.string.dog4))
        petInfoList.add(resources.getString(R.string.dog5))
    }
}