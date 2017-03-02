package com.gojek.sample.kotlin.views.create

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.text.InputType
import android.widget.ImageView
import com.gojek.sample.kotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout

class CreateUI : AnkoComponent<CreateActivity> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<CreateActivity>) = with(ui) {
        relativeLayout {
            id = R.id.content_create
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            appBarLayout {
                id = R.id.abl_create
                backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                elevation = dip(4).toFloat()

                toolbar {
                    id = R.id.tb_create
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    width = matchParent
                    height = wrapContent
                }
            }.lparams {
                width = matchParent
                height = wrapContent
            }

            scrollView {
                id = R.id.sv_create
                isFillViewport = true
                isScrollContainer = true

                verticalLayout {
                    isFocusable = true
                    isFocusableInTouchMode = true

                    imageView {
                        id = R.id.iv_create_photo
                        adjustViewBounds = true
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        background = ContextCompat.getDrawable(ctx, R.drawable.bg_camera)
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

                    editText {
                        id = R.id.et_create_firstname
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                        hint = ctx.resources.getString(R.string.hint_firstname)
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

                    editText {
                        id = R.id.et_create_lastname
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                        hint = ctx.resources.getString(R.string.hint_lastname)
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

                    editText {
                        id = R.id.et_create_email
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                        hint = ctx.resources.getString(R.string.hint_email)
                        inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
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

                    editText {
                        id = R.id.et_create_phonenumber
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                        textSize = 14f
                        hint = ctx.resources.getString(R.string.hint_email)
                        inputType = InputType.TYPE_TEXT_VARIATION_PHONETIC
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        topMargin = dip(4)
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }
                }
            }.lparams {
                below(R.id.abl_create)
            }.lparams {
                width = matchParent
                height = matchParent
            }
        }
    }
}