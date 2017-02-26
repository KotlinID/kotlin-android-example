package com.gojek.sample.kotlin.views.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gojek.sample.kotlin.R
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class HomeAdapter constructor(val contacts: List<String>) : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder = HomeHolder(HomeItemUI().createView(AnkoContext.create(parent.context, parent, false)))

    override fun onBindViewHolder(holder: HomeHolder?, position: Int) {
        val name = contacts[position]
        holder?.bind(name)
    }

    override fun getItemCount(): Int = contacts.size

    class HomeHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(contact: String) {
            with(contact) {
                val textView = itemView.find<TextView>(R.id.tv_homeitem_name)
                textView.text = contact
            }
        }
    }
}