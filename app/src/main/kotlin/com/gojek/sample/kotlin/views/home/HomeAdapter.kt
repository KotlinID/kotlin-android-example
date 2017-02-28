package com.gojek.sample.kotlin.views.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gojek.sample.kotlin.R
import com.gojek.sample.kotlin.extensions.loadImage
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

                // Set image and text
                loadImage(context, profilePic, R.mipmap.ic_launcher, photo)
                fullName.text = firstName.plus("").plus(lastName)
            }
        }
    }
}