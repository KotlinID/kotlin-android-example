package com.gojek.sample.kotlin.views.base

interface Presenter<in T : View> {
    fun onAttach(view: T)

    fun onDetach()
}