package com.gojek.sample.kotlin.views.home

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.gojek.sample.kotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout

class HomeUI : AnkoComponent<HomeActivity> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<HomeActivity>) = with(ui) {
        relativeLayout {
            id = R.id.content_home
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            appBarLayout {
                id = R.id.abl_home
                backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                elevation = dip(4).toFloat()

                toolbar {
                    id = R.id.tb_home
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    width = matchParent
                    height = wrapContent
                }
            }.lparams {
                width = matchParent
                height = wrapContent
            }

            progressBar {
                id = R.id.pb_home
                visibility = View.GONE
            }.lparams {
                centerInParent()
                width = wrapContent
                height = wrapContent
            }

            include<RecyclerView>(R.layout.widget_recyclerview).lparams {
                below(R.id.abl_home)
            }
        }
    }
}