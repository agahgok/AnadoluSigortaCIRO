package com.example.anadolusigortaciro.ui.onboarding.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anadolusigortaciro.databinding.FragmentViewPagerBinding
import com.example.anadolusigortaciro.ui.onboarding.OnBoardingFirstFragment
import com.example.anadolusigortaciro.ui.onboarding.OnBoardingSecondFragment
import com.example.anadolusigortaciro.ui.onboarding.OnBoardingThirdFragment
import com.example.anadolusigortaciro.ui.onboarding.viewpager.ViewPagerAdapter

class ViewPagerFragment : Fragment() {
    private lateinit var binding : FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewPagerBinding.inflate(inflater,container,false)
        val fragmentList = arrayListOf<Fragment>(
            OnBoardingFirstFragment(),
            OnBoardingSecondFragment(),
            OnBoardingThirdFragment()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter
        return binding.root
    }
}