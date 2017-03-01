package com.gojek.sample.kotlin.views.home

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import com.gojek.sample.kotlin.App
import com.gojek.sample.kotlin.R
import com.gojek.sample.kotlin.internal.data.local.model.Contacts
import com.gojek.sample.kotlin.internal.injectors.component.ActivityComponent
import com.gojek.sample.kotlin.internal.injectors.component.DaggerActivityComponent
import com.gojek.sample.kotlin.internal.injectors.module.ActivityModule
import com.gojek.sample.kotlin.views.base.BaseActivity
import com.gojek.sample.kotlin.views.create.CreateActivity
import com.gojek.sample.kotlin.views.detail.DetailActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView {

    companion object {
        lateinit var component: ActivityComponent
        lateinit var progressBar: ProgressBar
    }

    @Inject
    lateinit var presenter: HomePresenter

    override fun initComponents(savedInstanceState: Bundle?) {
        HomeUI().setContentView(this)
        inject()
        onAttach()
        onLoadContacts()
    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()
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
        setFloatingActionButton()
    }

    override fun onDetach() {
        presenter.onDetach()
    }

    override fun onShowProgressBar() {
        progressBar = find<ProgressBar>(R.id.pb_home)
        progressBar.visibility = View.VISIBLE
    }

    override fun onHideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onLoadContacts() {
        presenter.loadContacts()
    }

    override fun onShowContacts(contacts: List<Contacts>) {
        val recyclerView = find<RecyclerView>(R.id.rv_content)
        val layoutManager = LinearLayoutManager(this)
        val adapter = HomeAdapter(this, contacts, presenter)

        recyclerView.layoutManager = layoutManager
        recyclerView.smoothScrollToPosition(recyclerView.bottom)
        recyclerView.adapter = adapter
    }

    override fun onNavigateDetailScreen(id: Int?) {
        startActivity(intentFor<DetailActivity>("id" to id))
    }

    private fun setToolbar() {
        val toolbar = find<Toolbar>(R.id.tb_home)
        toolbar.title = title
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0)

        setSupportActionBar(toolbar)
    }

    private fun setFloatingActionButton() {
        val floatingActionButton = find<FloatingActionButton>(R.id.fab_home_add)
        floatingActionButton.setOnClickListener { view -> startActivity<CreateActivity>() }
    }
}