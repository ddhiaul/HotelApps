package com.aulia.idn.hotelapps

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hotel(
    var name: String,
    var location: String,
    var desc: String,
    var price: String,
    var image: Int
) : Parcelable