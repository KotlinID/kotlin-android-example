package com.gojek.sample.kotlin.views.home

import android.databinding.BaseObservable
import com.gojek.sample.kotlin.internal.data.remote.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val api: Api) : BaseObservable() {

    fun load() {
        api.getContacts().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe()
    }
}