package com.gojek.sample.kotlin.views.home

import com.gojek.sample.kotlin.internal.data.local.model.Contacts
import com.gojek.sample.kotlin.views.base.View

interface HomeView : View {
    fun onShowProgressBar()

    fun onHideProgressBar()

    fun onLoadContacts()

    fun onShowContacts(contacts: List<Contacts>)

    fun onNavigateDetailScreen(id: Int?)
}