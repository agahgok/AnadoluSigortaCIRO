package com.example.anadolusigortaciro.ui.home.insuranceservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.anadolusigortaciro.databinding.FragmentInsuranceServiceDetailBinding

class InsuranceServiceDetailFragment : Fragment() {
    private lateinit var binding : FragmentInsuranceServiceDetailBinding
    //private val args : InsuranceServiceDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsuranceServiceDetailBinding.inflate(inflater,container,false)

        /*binding.imInsuranceServiceDetailImage.setImageResource(args.insuranceServiceDetail.imageResource)
        binding.tvInsuranceServiceDetailTopic.text = args.insuranceServiceDetail.serviceName
        binding.tvInsuranceServiceDetail.text = args.insuranceServiceDetail.serviceDetail*/

        return binding.root
    }
}