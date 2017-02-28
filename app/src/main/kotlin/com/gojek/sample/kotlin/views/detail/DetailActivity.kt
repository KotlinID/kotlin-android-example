package com.gojek.sample.kotlin.views.detail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import com.gojek.sample.kotlin.App
import com.gojek.sample.kotlin.R
import com.gojek.sample.kotlin.internal.data.local.model.Contact
import com.gojek.sample.kotlin.internal.injectors.component.ActivityComponent
import com.gojek.sample.kotlin.internal.injectors.component.DaggerActivityComponent
import com.gojek.sample.kotlin.internal.injectors.module.ActivityModule
import com.gojek.sample.kotlin.views.base.BaseActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailView {

    companion object {
        lateinit var component: ActivityComponent
        lateinit var progressBar: ProgressBar
    }

    @Inject
    lateinit var presenter: DetailPresenter

    override fun initComponents(savedInstanceState: Bundle?) {
        DetailUI().setContentView(this)
        inject()
        onAttach()
    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
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

    override fun onShowProgressBar() {
        progressBar = find<ProgressBar>(R.id.pb_detail)
        progressBar.visibility = View.VISIBLE
    }

    override fun onHideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onLoadContact(id: Int) {
        presenter.loadContact(id)
    }

    override fun onShowContact(contact: Contact) {
    }

    private fun setToolbar() {
        val toolbar = find<Toolbar>(R.id.tb_detail)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.mipmap.ic_arrow_back)
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0)

        setSupportActionBar(toolbar)
    }
}