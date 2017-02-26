package com.gojek.sample.kotlin.internal.data.remote.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ContactResponse {

    @JsonProperty(value = "id")
    var id: Int? = 0

    @JsonProperty(value = "first_name")
    lateinit var firstName: String

    @JsonProperty(value = "last_name")
    lateinit var lastName: String

    @JsonProperty(value = "email")
    lateinit var email: String

    @JsonProperty(value = "phone_number")
    lateinit var phoneNumber: String

    @JsonProperty(value = "profile_pic")
    lateinit var profilePic: String
}