package com.gojek.sample.kotlin.internal.data.local.realm

import com.gojek.sample.kotlin.internal.data.local.RealmObjects
import com.gojek.sample.kotlin.internal.data.local.model.Contact
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

@RealmObjects
class ContactRealm : RealmObject() {

    @PrimaryKey
    var id: Int? = 0

    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var email: String
    lateinit var phoneNumber: String
    lateinit var profilePic: String

    internal fun fill(contact: Contact) {
        id = contact.id
        firstName = contact.firstName
        lastName = contact.lastName
        email = contact.email
        phoneNumber = contact.phoneNumber
        profilePic = contact.profilePic
    }
}