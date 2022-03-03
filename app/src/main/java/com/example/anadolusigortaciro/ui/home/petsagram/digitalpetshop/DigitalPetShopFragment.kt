package com.example.anadolusigortaciro.ui.home.petsagram.digitalpetshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentDigitalPetShopBinding
import com.example.anadolusigortaciro.model.ProductInfo

class DigitalPetShopFragment : Fragment() {
    private lateinit var binding : FragmentDigitalPetShopBinding
    private var catProductList = ArrayList<ProductInfo>()
    private val dogProductList = ArrayList<ProductInfo>()
    private val productList = ArrayList<ProductInfo>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDigitalPetShopBinding.inflate(inflater,container,false)

        val catProductModel = ProductInfo(R.drawable.cat_food,"Trendyol.com",829,"https://www.trendyol.com/proplan/somonlu-kisirlastirilmis-kedi-mamasi-10-kg-p-749840")
        val catProductModel2 = ProductInfo(R.drawable.cat_litter,"Trendyol.com",64,"https://www.trendyol.com/marcat/lavanta-kokulu-ince-taneli-topaklanan-kedi-kumu-20-lt-p-64870595?boutiqueId=590714&merchantId=152762")
        val catProductModel3 = ProductInfo(R.drawable.overflow,"Trendyol.com",489,"https://www.trendyol.com/kospet/gps-evcil-hayvan-kedi-kopek-sim-kartli-izleme-konum-bulma-ve-takip-etme-cihazi-ip67-dayanikli-p-205185755?boutiqueId=61&merchantId=190828")

        val dogProductModel = ProductInfo(R.drawable.food_dog,"Trendyol.com",628,"https://www.trendyol.com/purina/pro-plan-medium-kuzu-etli-yavru-kopek-mamasi-12-kg-p-66977567?boutiqueId=590714&merchantId=281103")
        val dogProductModel2 = ProductInfo(R.drawable.dog_tshirt,"Trendyol.com",109,"https://www.trendyol.com/dogi-dog/buyuk-irk-navy-kopek-yagmurlugu-kopek-kiyafeti-p-137678920")
        val dogProductModel3 = ProductInfo(R.drawable.overflow,"Trendyol.com",489,"https://www.trendyol.com/kospet/gps-evcil-hayvan-kedi-kopek-sim-kartli-izleme-konum-bulma-ve-takip-etme-cihazi-ip67-dayanikli-p-205185755?boutiqueId=61&merchantId=190828")

        catProductList.add(catProductModel)
        catProductList.add(catProductModel2)
        catProductList.add(catProductModel3)
        dogProductList.add(dogProductModel)
        dogProductList.add(dogProductModel2)
        dogProductList.add(dogProductModel3)

        productList.add(catProductModel)
        productList.add(catProductModel2)
        productList.add(catProductModel3)
        productList.add(dogProductModel)
        productList.add(dogProductModel2)
        productList.add(dogProductModel3)

        setRecyclerViewAdapter(productList)
        return binding.root
    }
    private fun setRecyclerViewAdapter(list : ArrayList<ProductInfo>){
        val mLayoutManager = LinearLayoutManager(context)
        binding.recyclerViewDigitalPetshop.layoutManager = mLayoutManager
        binding.recyclerViewDigitalPetshop.adapter = context?.let {
            DigitalPetshopAdapter(it,list)
        }
    }
}
