package com.gojek.sample.kotlin.internal.data.local

import com.gojek.sample.kotlin.internal.data.local.dao.ContactDao
import com.gojek.sample.kotlin.internal.data.local.dao.ContactsDao
import com.gojek.sample.kotlin.internal.data.local.model.Contact
import com.gojek.sample.kotlin.internal.data.local.model.Contacts
import com.gojek.sample.kotlin.internal.data.local.realm.ContactRealm
import com.gojek.sample.kotlin.internal.data.local.realm.ContactsRealm

class RealmManagers {

    internal fun saveOrUpdateContacts(contacts: Contacts) {
        val data: ContactsRealm = ContactsRealm()
        val dao: ContactsDao = ContactsDao()
        data.fill(contacts)
        dao.saveOrUpdate(data)
    }

    internal fun getAllContacts(): List<ContactsRealm> {
        val dao: ContactsDao = ContactsDao()
        return dao.findAll()
    }

    internal fun getContacts(): ContactsRealm {
        val dao: ContactsDao = ContactsDao()
        return dao.findOne()
    }

    internal fun deleteContacts() {
        val dao: ContactsDao = ContactsDao()
        dao.delete()
    }

    internal fun saveOrUpdateContact(contact: Contact) {
        val data: ContactRealm = ContactRealm()
        val dao: ContactDao = ContactDao()
        data.fill(contact)
        dao.saveOrUpdate(data)
    }

    internal fun getAllContact(): List<ContactRealm> {
        val dao: ContactDao = ContactDao()
        return dao.findAll()
    }

    internal fun getContact(): ContactRealm {
        val dao: ContactDao = ContactDao()
        return dao.findOne()
    }

    internal fun deleteContact() {
        val dao: ContactDao = ContactDao()
        dao.delete()
    }
}