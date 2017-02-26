package com.gojek.sample.kotlin.internal.data.remote

import com.gojek.sample.kotlin.internal.data.remote.request.ContactRequest
import com.gojek.sample.kotlin.internal.data.remote.response.ContactResponse
import com.gojek.sample.kotlin.internal.data.remote.response.ContactsResponse
import io.reactivex.Flowable
import retrofit2.http.*

interface Api {

    @GET("/contacts")
    fun getContacts(): Flowable<List<ContactsResponse>>

    @GET("/contact/{id}")
    fun getContact(@Path("id") id: Int?): Flowable<ContactResponse>

    @POST("/contact")
    fun createContact(@Body contactRequest: ContactRequest): Flowable<ContactResponse>

    @PUT("/contact/{id}")
    fun updateContact(@Path("id") id: Int?, @Body contactRequest: ContactRequest): Flowable<ContactResponse>
}