package com.gojek.sample.kotlin.extensions

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

internal fun initialRealm(context: Context, schema: String, version: Long) {
    // Initial Realm
    Realm.init(context)

    // Initial Realm Configuration
    val configuration: RealmConfiguration = RealmConfiguration.Builder().name(schema).schemaVersion(version).deleteRealmIfMigrationNeeded().build()

    // Set Default Realm Configuration
    Realm.setDefaultConfiguration(configuration)
    Realm.getInstance(configuration)
}