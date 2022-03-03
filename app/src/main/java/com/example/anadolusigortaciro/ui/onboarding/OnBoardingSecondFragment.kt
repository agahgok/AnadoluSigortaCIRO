package com.example.anadolusigortaciro.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentOnBoardingSecondBinding

class OnBoardingSecondFragment : Fragment() {
    private lateinit var binding : FragmentOnBoardingSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingSecondBinding.inflate(inflater,container,false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnOnBoardingSecondNext.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return binding.root
    }

}