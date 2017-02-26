package com.gojek.sample.kotlin.views.home

import android.support.v4.content.ContextCompat
import android.view.View
import com.gojek.sample.kotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class HomeUI : AnkoComponent<HomeActivity> {

    override fun createView(ui: AnkoContext<HomeActivity>) = with(ui) {
        coordinatorLayout {
            id = R.id.cl_main
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                appBarLayout {
                    id = R.id.abl_main
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)

                    toolbar {
                        id = R.id.toolbar_main
                        setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                    }
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }

                progressBar {
                    id = R.id.pb_main
                    visibility = View.GONE
                }.lparams {
                    below(R.id.abl_main)
                    centerInParent()
                    width = wrapContent
                    height = wrapContent
                }

                recyclerView {
                    id = R.id.rv_main
                }.lparams {
                    below(R.id.abl_main)
                    width = matchParent
                    height = wrapContent
                }
            }
        }
    }
}