package com.gojek.sample.kotlin.views.home

import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
import android.util.TypedValue
import android.view.ViewGroup
import com.gojek.sample.kotlin.R
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class HomeItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        val typedValue: TypedValue = TypedValue()

        frameLayout {
            cardView {
                id = R.id.cv_homeitem
                cardBackgroundColor = AppCompatResources.getColorStateList(ctx, R.color.colorPrimary)
                radius = dip(4).toFloat()
                cardElevation = dip(2).toFloat()
                preventCornerOverlap = false

                relativeLayout {
                    ctx.theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)
                    backgroundResource = typedValue.resourceId

                    include<CircleImageView>(R.layout.widget_circleimageview).lparams {
                        alignParentStart()
                    }

                    textView {
                        id = R.id.tv_homeitem_name
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                        textSize = 14f
                    }.lparams {
                        rightOf(R.id.civ_content)
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