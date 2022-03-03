package com.example.anadolusigortaciro.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentOnBoardingFirstBinding

class OnBoardingFirstFragment : Fragment() {
    private lateinit var binding : FragmentOnBoardingFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingFirstBinding.inflate(inflater,container,false)
        val viewPager =activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnOnBoardingFirstNext.setOnClickListener {
            viewPager?.currentItem = 1
        }
        return binding.root
    }
}