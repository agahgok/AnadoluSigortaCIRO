package com.example.anadolusigortaciro.ui.home.petsagram.digitalpetshop

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.model.ProductInfo
import kotlin.collections.ArrayList

class DigitalPetshopAdapter(
    private val context : Context,
    private val productList : ArrayList<ProductInfo>
) : RecyclerView.Adapter<DigitalPetshopAdapter.DigitalPetshopViewHolder>(){

    inner class DigitalPetshopViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){
            val currentItem = productList[position]
            val productBrand : TextView = itemView.findViewById(R.id.tvDigitalPetshopProductBrand)
            val productImage : ImageView = itemView.findViewById(R.id.imDigitalPetshopBanner)
            val productPrice : TextView  = itemView.findViewById(R.id.tvDigitalPetshopPrice)
            val buyNow : TextView = itemView.findViewById(R.id.tvBuyNow)

            productBrand.text = currentItem.productBrand
            productImage.setImageResource(currentItem.productImage)
            productPrice.text = currentItem.productPrice.toString()

            buyNow.setOnClickListener {
                goToUrl(currentItem.productBrandLink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigitalPetshopViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.item_digital_pethshop_card,
            parent,
            false
        )
        return DigitalPetshopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DigitalPetshopViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = productList.size

    private fun goToUrl(url : String){
        val uri : Uri = Uri.parse(url)
        context.startActivity(Intent(Intent.ACTION_VIEW,uri))
    }
}