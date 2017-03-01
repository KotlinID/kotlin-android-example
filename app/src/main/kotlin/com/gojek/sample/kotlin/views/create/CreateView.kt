package com.gojek.sample.kotlin.views.create

import com.gojek.sample.kotlin.views.base.View

interface CreateView : View {
    fun onCreateContact()

    fun onShowProgressDialog()

    fun onHideProgressDialog()
}