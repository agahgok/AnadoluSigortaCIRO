package com.example.anadolusigortaciro.ui.onboarding.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    list: ArrayList<Fragment>,
    fm: FragmentManager,
    lifeCycle: Lifecycle
) : FragmentStateAdapter(fm, lifeCycle) {
    private val fragmentList = list

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}