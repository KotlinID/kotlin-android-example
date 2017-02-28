package com.gojek.sample.kotlin.views.detail

import com.gojek.sample.kotlin.internal.data.local.RealmManagers
import com.gojek.sample.kotlin.internal.data.local.model.Contact
import com.gojek.sample.kotlin.internal.data.local.realm.ContactRealm
import com.gojek.sample.kotlin.internal.data.remote.Api
import com.gojek.sample.kotlin.internal.data.remote.response.ContactResponse
import com.gojek.sample.kotlin.views.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val api: Api) : Presenter<DetailView> {
    var view: DetailView? = null

    @Inject
    lateinit var realmManagers: RealmManagers

    override fun onAttach(view: DetailView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun loadContact(id: Int) {
        if (checkContact(id) != id) {
            view?.onShowProgressBar()
            api.getContact(id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({ setContactResponse(it) }, Throwable::printStackTrace)
        } else {
            val contactRealm: ContactRealm? = realmManagers.getContactById(id)
            val contact: Contact = Contact(
                    contactRealm?.id,
                    contactRealm?.firstName,
                    contactRealm?.lastName,
                    contactRealm?.email,
                    contactRealm?.phoneNumber,
                    contactRealm?.profilePic
            )

            view?.onShowContact(contact)
        }
    }

    fun setContactResponse(response: ContactResponse) {
        val contact: Contact = Contact(
                response.id,
                response.firstName,
                response.lastName,
                response.email,
                response.phoneNumber,
                response.profilePic
        )

        realmManagers.saveOrUpdateContact(contact)
        view?.onHideProgressBar()
        view?.onShowContact(contact)
    }

    private fun checkContact(id: Int?): Int? = realmManagers.getContactById(id)?.id
}