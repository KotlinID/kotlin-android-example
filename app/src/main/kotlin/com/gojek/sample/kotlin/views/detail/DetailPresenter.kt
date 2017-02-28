package com.gojek.sample.kotlin.views.detail

import com.gojek.sample.kotlin.internal.data.remote.Api
import com.gojek.sample.kotlin.views.base.Presenter
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val api: Api) : Presenter<DetailView> {
    var view: DetailView? = null

    override fun onAttach(view: DetailView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }
}