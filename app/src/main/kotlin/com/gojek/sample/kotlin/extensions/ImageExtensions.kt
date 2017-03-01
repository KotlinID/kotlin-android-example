package com.gojek.sample.kotlin.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import de.hdodenhof.circleimageview.CircleImageView

internal fun loadImage(context: Context, url: String?, imageView: ImageView) {
    setMemoryCategory(context)
    Glide.with(context)
         .load(url)
         .centerCrop()
         .diskCacheStrategy(DiskCacheStrategy.SOURCE)
         .override(imageView.maxWidth, Target.SIZE_ORIGINAL)
         .into(imageView)
}

internal fun loadImageCircle(context: Context, url: String, resourceId: Int, circleImageView: CircleImageView) {
    setMemoryCategory(context)
    Glide.with(context)
         .load(url)
         .centerCrop()
         .diskCacheStrategy(DiskCacheStrategy.SOURCE)
         .placeholder(resourceId).error(resourceId)
         .dontAnimate()
         .into(object : SimpleTarget<GlideDrawable>(128, 128) {
             override fun onLoadStarted(placeholder: Drawable?) {
                 circleImageView.setImageDrawable(placeholder)
             }

             override fun onLoadFailed(e: Exception?, errorDrawable: Drawable?) {
                 circleImageView.setImageDrawable(errorDrawable)
             }

             override fun onResourceReady(resource: GlideDrawable?, glideAnimation: GlideAnimation<in GlideDrawable>) {
                 circleImageView.setImageDrawable(resource)
             }
         })
}

internal fun setMemoryCategory(context: Context) {
    Glide.get(context).setMemoryCategory(MemoryCategory.HIGH);
}