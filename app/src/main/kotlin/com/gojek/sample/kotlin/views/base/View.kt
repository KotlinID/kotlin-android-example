package com.gojek.sample.kotlin.views.base

interface View {
    fun inject()

    fun onAttach()

    fun onDetach()
}