package com.gojek.sample.kotlin.views.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.gojek.sample.kotlin.App
import com.gojek.sample.kotlin.R
import com.gojek.sample.kotlin.internal.injectors.component.ActivityComponent
import com.gojek.sample.kotlin.internal.injectors.component.DaggerActivityComponent
import com.gojek.sample.kotlin.internal.injectors.module.ActivityModule
import com.gojek.sample.kotlin.views.base.BaseActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView {

    companion object {
        lateinit var component: ActivityComponent
    }

    @Inject
    lateinit var presenter: HomePresenter

    override fun initComponents(savedInstanceState: Bundle?) {
        HomeUI().setContentView(this)
        inject()
        onAttach()
        onLoadContacts()
    }

    override fun inject() {
        component = DaggerActivityComponent.builder().applicationComponent(App.component)
                                                     .activityModule(ActivityModule(this))
                                                     .build()
        component.inject(this)
    }

    override fun onAttach() {
        presenter.onAttach(this)
        setToolbar()
    }

    override fun onDetach() {
        presenter.onDetach()
    }

    override fun onLoadContacts() {
        presenter.loadContacts()
        setAdapter()
    }

    private fun setToolbar() {
        val toolbar = find<Toolbar>(R.id.tb_home)
        toolbar.title = title
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0)

        setSupportActionBar(toolbar)
    }

    private fun setAdapter() {
        val contacts: List<String> = listOf("Budi", "Oktaviyan", "Suryanto")
        val recyclerView = find<RecyclerView>(R.id.rv_content)
        val layoutManager = LinearLayoutManager(this)
        val adapter = HomeAdapter(contacts)

        recyclerView.layoutManager = layoutManager
        recyclerView.smoothScrollToPosition(recyclerView.bottom)
        recyclerView.adapter = adapter
    }
}