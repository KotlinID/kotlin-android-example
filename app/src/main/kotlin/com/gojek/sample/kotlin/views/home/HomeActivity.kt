package com.gojek.sample.kotlin.views.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.gojek.sample.kotlin.R
import com.gojek.sample.kotlin.views.base.BaseActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class HomeActivity : BaseActivity() {

    override fun initComponents(savedInstanceState: Bundle?) {
        HomeUI().setContentView(this)
        setToolbar()
        setAdapter()
    }

    private fun setToolbar() {
        val toolbar = find<Toolbar>(R.id.toolbar_main)
        toolbar.title = title
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0)

        setSupportActionBar(toolbar)
    }

    private fun setAdapter() {
        val contacts: List<String> = listOf("Budi", "Oktaviyan", "Suryanto")
        val adapter = HomeAdapter(contacts)
        val recyclerView = find<RecyclerView>(R.id.rv_main)
        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        recyclerView.smoothScrollToPosition(recyclerView.bottom)
        recyclerView.adapter = adapter
    }
}