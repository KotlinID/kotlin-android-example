package com.gojek.sample.kotlin.views.detail

import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

class DetailUI : AnkoComponent<DetailActivity> {

    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        verticalLayout {
        }
    }
}