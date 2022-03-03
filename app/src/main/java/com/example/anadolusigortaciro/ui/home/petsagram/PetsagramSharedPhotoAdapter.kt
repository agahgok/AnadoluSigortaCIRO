package com.example.anadolusigortaciro.ui.home.petsagram

import android.content.Context
import android.content.SharedPreferences
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.model.SharedPhoto
import com.squareup.picasso.Picasso

class PetsagramSharedPhotoAdapter(
    private val context : Context,
    private val photoList : ArrayList<SharedPhoto>
    ) : RecyclerView.Adapter<PetsagramSharedPhotoAdapter.PetsagramSharedPhotoViewHolder>() {

    inner class PetsagramSharedPhotoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){
            val image : ImageView = itemView.findViewById(R.id.imSharedPhoto)
            val username : TextView = itemView.findViewById(R.id.tvPhotoUsername)
            val sharedDate : TextView = itemView.findViewById(R.id.tvPhotoSharedDate)

            val currentItem = photoList[position]

            if(currentItem.imageUri.isEmpty()){
                image.setImageResource(R.mipmap.ic_launcher)
            }else{
                Picasso.get()
                    .load(currentItem.imageUri)
                    .placeholder(R.drawable.camera_24)
                    .fit()
                    .centerCrop()
                    .into(image)
            }
            username.text = currentItem.username
            sharedDate.text = currentItem.date
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PetsagramSharedPhotoViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.item_shared_photo,
            parent,
            false
        )
        return PetsagramSharedPhotoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PetsagramSharedPhotoViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}