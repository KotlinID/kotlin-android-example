package com.gojek.sample.kotlin.internal.data.local.model

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Contacts @ParcelConstructor constructor(
        val id: Int?,
        val firstName: String,
        val lastName: String,
        val profilePic: String
)