package com.example.anadolusigortaciro.ui.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentOnBoardingThirdBinding

class OnBoardingThirdFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingThirdBinding.inflate(inflater, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onBoardingDone()
        }
        return binding.root
    }

    private fun onBoardingDone() {
        val sharedPreferences =
            requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("done", true)
        editor.apply()
    }
}