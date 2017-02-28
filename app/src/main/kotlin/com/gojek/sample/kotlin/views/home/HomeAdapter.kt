package com.gojek.sample.kotlin.views.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gojek.sample.kotlin.R
import com.gojek.sample.kotlin.internal.data.local.model.Contacts
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class HomeAdapter constructor(val context: Context, val contacts: List<Contacts>) : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder = HomeHolder(HomeItemUI().createView(AnkoContext.create(parent.context, parent, false)))

    override fun onBindViewHolder(holder: HomeHolder?, position: Int) {
        val contact = contacts[position]
        holder?.bind(context, contact)
    }

    override fun getItemCount(): Int = contacts.size

    class HomeHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(context: Context, contact: Contacts) {
            with(contact) {
                val photo = itemView.find<CircleImageView>(R.id.civ_content)
                val fullName = itemView.find<TextView>(R.id.tv_homeitem_name)
                val profilePic = contact.profilePic
                val firstName = contact.firstName
                val lastName = contact.lastName

                // Set image
                Glide.get(context).setMemoryCategory(MemoryCategory.HIGH)
                Glide.with(context)
                     .load(profilePic)
                     .placeholder(R.mipmap.ic_launcher)
                     .error(R.mipmap.ic_launcher)
                     .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                     .dontAnimate()
                     .into(photo)

                // Set text
                fullName.text = firstName.plus("").plus(lastName)
            }
        }
    }
}