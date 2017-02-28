package com.gojek.sample.kotlin.views.detail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import com.gojek.sample.kotlin.App
import com.gojek.sample.kotlin.R
import com.gojek.sample.kotlin.extensions.loadImage
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
        onLoadContact()
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

    override fun onLoadContact() {
        val id: Int = intent.getIntExtra("id", -1)
        presenter.loadContact(id)
    }

    override fun onShowContact(contact: Contact?) {
        val photo = find<ImageView>(R.id.iv_detail_photo)
        val firstName = find<TextView>(R.id.tv_detail_firstname)
        val lastName = find<TextView>(R.id.tv_detail_lastname)
        val email = find<TextView>(R.id.tv_detail_email)
        val phoneNumber = find<TextView>(R.id.tv_detail_phonenumber)
        val scrollView = find<ScrollView>(R.id.sv_detail)

        loadImage(this, contact?.profilePic, photo)
        firstName.text = contact?.firstName
        lastName.text = contact?.lastName
        email.text = contact?.email
        phoneNumber.text = contact?.phoneNumber
        scrollView.visibility = View.VISIBLE
    }

    private fun setToolbar() {
        val toolbar = find<Toolbar>(R.id.tb_detail)
        toolbar.title = title
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.mipmap.ic_arrow_back)
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0)

        setSupportActionBar(toolbar)
    }
}