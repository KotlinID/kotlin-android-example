package com.gojek.sample.kotlin.internal.data.local.dao

import com.gojek.sample.kotlin.internal.data.local.realm.ContactRealm
import io.realm.Realm
import io.realm.RealmResults
import io.realm.internal.IOException

class ContactDao : Dao<ContactRealm> {

    override fun saveOrUpdate(data: ContactRealm) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({ realm -> realm.insertOrUpdate(data) }, { realm.close() }) { realm.close() }
    }

    override fun findAll(): List<ContactRealm> {
        val realm: Realm = Realm.getDefaultInstance()
        val data: RealmResults<ContactRealm> = realm.where(ContactRealm::class.java).findAll()
        realm.close()

        return data
    }

    override fun findOne(): ContactRealm {
        try {
            val realm: Realm = Realm.getDefaultInstance()
            val data: ContactRealm = realm.copyFromRealm(realm.where(ContactRealm::class.java).findFirst())
            realm.close()

            return data
        } catch (e: IOException) {
            e.printStackTrace()
            return ContactRealm()
        }
    }

    override fun delete() {
        val realm: Realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({ realm -> realm.delete(ContactRealm::class.java) }, { realm.close() }) { realm.close() }
    }
}