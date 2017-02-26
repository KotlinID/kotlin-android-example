package com.gojek.sample.kotlin.internal.data.local.dao

import com.gojek.sample.kotlin.internal.data.local.realm.ContactsRealm
import io.realm.Realm
import io.realm.RealmResults
import io.realm.internal.IOException

class ContactsDao : Dao<ContactsRealm> {

    override fun saveOrUpdate(data: ContactsRealm) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({ realm -> realm.insertOrUpdate(data) }, { realm.close() }) { realm.close() }
    }

    override fun findAll(): List<ContactsRealm> {
        val realm: Realm = Realm.getDefaultInstance()
        val data: RealmResults<ContactsRealm> = realm.where(ContactsRealm::class.java).findAll()
        realm.close()

        return data
    }

    override fun findOne(): ContactsRealm {
        try {
            val realm: Realm = Realm.getDefaultInstance()
            val data: ContactsRealm = realm.copyFromRealm(realm.where(ContactsRealm::class.java).findFirst())
            realm.close()

            return data
        } catch (e: IOException) {
            e.printStackTrace()
            return ContactsRealm()
        }
    }

    override fun delete() {
        val realm: Realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({ realm -> realm.delete(ContactsRealm::class.java) }, { realm.close() }) { realm.close() }
    }
}