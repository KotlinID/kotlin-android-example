package com.gojek.sample.kotlin.internal.data.local.model

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class NewContact @ParcelConstructor constructor(
        val firstName: String,
        val lastName: String,
        val email: String,
        val phoneNumber: String,
        val profilePic: String
)