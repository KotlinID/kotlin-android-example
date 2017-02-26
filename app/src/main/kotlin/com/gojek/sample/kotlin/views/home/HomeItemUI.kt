package com.gojek.sample.kotlin.views.home

import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.ViewGroup
import com.gojek.sample.kotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class HomeItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        val typedValue: TypedValue = TypedValue()

        frameLayout {
            cardView {
                cardElevation = dip(2).toFloat()

                relativeLayout {
                    ctx.theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)
                    backgroundResource = typedValue.resourceId

                    imageView {
                        id = R.id.iv_main_photo
                        setImageResource(R.mipmap.ic_launcher)
                    }.lparams {
                        alignParentStart()
                        width = dip(64)
                        height = dip(64)
                        padding = dip(8)
                    }

                    textView {
                        id = R.id.tv_main_name
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                        textSize = 14f
                    }.lparams {
                        rightOf(R.id.iv_main_photo)
                        centerInParent()
                        width = matchParent
                        height = wrapContent
                        padding = dip(8)
                    }
                }
            }.lparams {
                width = matchParent
                height = wrapContent
                margin = dip(8)
                isClickable = true
            }
        }
    }
}