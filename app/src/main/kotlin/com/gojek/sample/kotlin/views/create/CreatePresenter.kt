package com.gojek.sample.kotlin.views.create

import com.gojek.sample.kotlin.internal.data.local.RealmManagers
import com.gojek.sample.kotlin.internal.data.local.model.Contact
import com.gojek.sample.kotlin.internal.data.local.model.NewContact
import com.gojek.sample.kotlin.internal.data.remote.Api
import com.gojek.sample.kotlin.internal.data.remote.request.ContactRequest
import com.gojek.sample.kotlin.internal.data.remote.response.ContactResponse
import com.gojek.sample.kotlin.views.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CreatePresenter @Inject constructor(private val api: Api) : Presenter<CreateView> {
    var view: CreateView? = null

    @Inject
    lateinit var realmManagers: RealmManagers

    override fun onAttach(view: CreateView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun createContact(newContact: NewContact) {
        // Show progress dialog
        view?.onShowProgressDialog()

        // Set request data
        val firstName: String = newContact.firstName
        val lastName: String = newContact.lastName
        val email: String = newContact.email
        val phoneNumber: String = newContact.phoneNumber
        val profilePic: String = newContact.profilePic

        val request: ContactRequest = ContactRequest()
        request.firstName = firstName
        request.lastName = lastName
        request.email = email
        request.phoneNumber = phoneNumber
        request.profilePic = profilePic

        api.createContact(request).observeOn(AndroidSchedulers.mainThread()).subscribe({ setContactResponse(it) }, Throwable::printStackTrace)
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
        view?.onHideProgressDialog()
    }
}