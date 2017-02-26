package com.gojek.sample.kotlin.internal.data.local.realm

import com.gojek.sample.kotlin.internal.data.local.RealmObjects
import com.gojek.sample.kotlin.internal.data.local.model.Contacts
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

@RealmObjects
class ContactsRealm : RealmObject() {

    @PrimaryKey
    var id: Int? = 0

    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var profilePic: String

    internal fun fill(contacts: Contacts) {
        id = contacts.id
        firstName = contacts.firstName
        lastName = contacts.lastName
        profilePic = contacts.profilePic
    }
}