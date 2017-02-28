package com.gojek.sample.kotlin.views.detail

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
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
                visibility = View.GONE
            }.lparams {
                centerInParent()
                width = wrapContent
                height = wrapContent
            }

            scrollView {
                isFillViewport = true

                verticalLayout {
                    imageView {
                        id = R.id.iv_detail_photo
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }.lparams {
                        width = matchParent
                        height = dip(200)
                    }

                    textView {
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                        textSize = 16f
                        text = ctx.resources.getString(R.string.text_firstname)
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        margin = dip(8)
                    }

                    textView {
                        id = R.id.tv_detail_firstname
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        topMargin = dip(4)
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }

                    textView {
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                        textSize = 16f
                        text = ctx.resources.getString(R.string.text_lastname)
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        margin = dip(8)
                    }

                    textView {
                        id = R.id.tv_detail_lastname
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        topMargin = dip(4)
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }

                    textView {
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                        textSize = 16f
                        text = ctx.resources.getString(R.string.text_email)
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        margin = dip(8)
                    }

                    textView {
                        id = R.id.tv_detail_email
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        topMargin = dip(4)
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }

                    textView {
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                        textSize = 16f
                        text = ctx.resources.getString(R.string.text_phonenumber)
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        margin = dip(8)
                    }

                    textView {
                        id = R.id.tv_detail_phonenumber
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        topMargin = dip(4)
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                }
            }.lparams {
                below(R.id.abl_detail)
            }
        }
    }
}