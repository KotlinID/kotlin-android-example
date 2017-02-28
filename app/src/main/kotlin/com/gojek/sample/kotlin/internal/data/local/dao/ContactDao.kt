package com.gojek.sample.kotlin.internal.data.local.dao

import com.gojek.sample.kotlin.extensions.membersOf
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
        val data: RealmResults<ContactRealm> = realm.where(membersOf<ContactRealm>()).findAll()
        realm.close()

        return data
    }

    override fun findOne(): ContactRealm {
        try {
            val realm: Realm = Realm.getDefaultInstance()
            val data: ContactRealm = realm.copyFromRealm(realm.where(membersOf<ContactRealm>()).findFirst())
            realm.close()

            return data
        } catch (e: IOException) {
            e.printStackTrace()
            return ContactRealm()
        }
    }

    override fun delete() {
        val realm: Realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({ realm -> realm.delete(membersOf<ContactRealm>()) }, { realm.close() }) { realm.close() }
    }

    fun findById(id: Int?): ContactRealm? {
        val realm: Realm = Realm.getDefaultInstance()
        var data: ContactRealm? = realm.where<ContactRealm>(membersOf<ContactRealm>()).equalTo("id", id).findFirst()

        if (null != data) {
            data = realm.copyFromRealm(data)
        } else {
            data = ContactRealm()
        }

        realm.close()
        return data
    }
}