package com.gojek.sample.kotlin.views.home

import com.gojek.sample.kotlin.internal.data.local.RealmManagers
import com.gojek.sample.kotlin.internal.data.local.model.Contacts
import com.gojek.sample.kotlin.internal.data.local.realm.ContactsRealm
import com.gojek.sample.kotlin.internal.data.remote.Api
import com.gojek.sample.kotlin.internal.data.remote.response.ContactsResponse
import com.gojek.sample.kotlin.views.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(private val api: Api) : Presenter<HomeView> {
    var view: HomeView? = null

    @Inject
    lateinit var realmManagers: RealmManagers

    override fun onAttach(view: HomeView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun loadContacts() {
        if (checkContacts() != 0) {
            val contactsRealm: List<ContactsRealm> = realmManagers.getAllContacts()
            val contacts: List<Contacts> = contactsRealm.map {
                val id: Int? = it.id
                val firstName: String = it.firstName
                val lastName: String = it.lastName
                val profilePic: String = it.profilePic

                Contacts(id, firstName, lastName, profilePic)
            }

            view?.onShowContacts(contacts)
        } else {
            view?.onShowProgressBar()
            api.getContacts().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({ setContactsResponse(it) }, Throwable::printStackTrace)
        }
    }

    fun setContactsResponse(response: List<ContactsResponse>) {
        val contacts: List<Contacts> = response.map {
            val id: Int? = it.id
            val firstName: String = it.firstName
            val lastName: String = it.lastName
            val profilePic: String = it.profilePic

            Contacts(id, firstName, lastName, profilePic)
        }

        contacts.forEach { realmManagers.saveOrUpdateContacts(it) }
        view?.onHideProgressBar()
        view?.onShowContacts(contacts)
    }

    private fun checkContacts(): Int = realmManagers.getAllContacts().size
}