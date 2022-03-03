package com.example.anadolusigortaciro.ui.splashscreen

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {
    private lateinit var binding : FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater,container,false)
        binding.splashAnimation.speed = 1.5f
        Handler().postDelayed({
            if(checkOnBoardingDone()){
                findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
            }else
                findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)
        },4000)

        return binding.root
    }

    private fun checkOnBoardingDone() : Boolean{
        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("done",false)
    }
}