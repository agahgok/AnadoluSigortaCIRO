package com.example.anadolusigortaciro.model

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.parcelize.Parcelize

@kotlinx.android.parcel.Parcelize
data class InsuranceServiceModel(
    val serviceName : String = "",
    val imageResource : Int = 0,
    val serviceDetail : String = ""
) : Parcelable
