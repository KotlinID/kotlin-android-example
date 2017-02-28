package com.gojek.sample.kotlin.views.detail

import com.gojek.sample.kotlin.internal.data.local.model.Contact
import com.gojek.sample.kotlin.views.base.View

interface DetailView : View {
    fun onShowProgressBar()

    fun onHideProgressBar()

    fun onLoadContact()

    fun onShowContact(contact: Contact?)
}