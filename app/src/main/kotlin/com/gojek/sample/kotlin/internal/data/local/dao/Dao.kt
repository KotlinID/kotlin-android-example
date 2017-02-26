package com.gojek.sample.kotlin.internal.data.local.dao

import io.realm.RealmObject

interface Dao<T : RealmObject> {
    fun saveOrUpdate(data: T)

    fun findAll(): List<T>

    fun findOne(): T

    fun delete()
}