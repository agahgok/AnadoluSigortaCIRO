package com.example.anadolusigortaciro.ui.home.petsagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anadolusigortaciro.databinding.FragmentPetsagramBinding
import com.example.anadolusigortaciro.ui.home.petsagram.digitalpetshop.DigitalPetShopFragment
import com.example.anadolusigortaciro.ui.home.petsagram.viewpager.PetsagramViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PetsagramFragment : Fragment() {
    private val tabLayoutTitles = ArrayList<String>()
    private val fragmentList = ArrayList<Fragment>()
    private lateinit var binding : FragmentPetsagramBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetsagramBinding.inflate(inflater,container,false)
        fragmentList.add(PetsagramSharePhotoFragment())
        fragmentList.add(DigitalPetShopFragment())

        val adapter = PetsagramViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter

        tabLayoutTitles.add("Sosyal")
        tabLayoutTitles.add("Dijital Petshop")

        TabLayoutMediator(binding.tabLayoutPetsagram,binding.viewPager){tab,position ->
            tab.text =tabLayoutTitles[position]
        }.attach()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tabLayoutTitles.clear()
        fragmentList.clear()
    }
}