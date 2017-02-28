package com.gojek.sample.kotlin.views.detail

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import com.gojek.sample.kotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout

class DetailUI : AnkoComponent<DetailActivity> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        relativeLayout {
            id = R.id.content_detail
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            appBarLayout {
                id = R.id.abl_detail
                backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                elevation = dip(4).toFloat()

                toolbar {
                    id = R.id.tb_detail
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
                id = R.id.pb_detail
            }.lparams {
                centerInParent()
                width = wrapContent
                height = wrapContent
            }
        }
    }
}