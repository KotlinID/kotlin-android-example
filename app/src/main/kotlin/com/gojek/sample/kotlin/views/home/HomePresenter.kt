package com.gojek.sample.kotlin.views.home

import com.gojek.sample.kotlin.internal.data.remote.Api
import com.gojek.sample.kotlin.views.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(private val api: Api) : Presenter<HomeView> {
    var view: HomeView? = null

    override fun onAttach(view: HomeView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun loadContacts() {
        api.getContacts().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe()
    }
}