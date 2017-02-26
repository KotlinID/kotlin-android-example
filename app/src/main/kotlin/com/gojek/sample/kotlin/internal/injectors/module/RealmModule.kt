package com.gojek.sample.kotlin.internal.injectors.module

import android.content.Context
import com.gojek.sample.kotlin.extensions.realmSchema
import com.gojek.sample.kotlin.extensions.realmSchemaVersion
import com.gojek.sample.kotlin.internal.data.local.RealmManagers
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
class RealmModule constructor(private val context: Context) {

    @Provides
    @Singleton
    fun provideRealmManagers(): RealmManagers {
        initialRealm(context, realmSchema(), realmSchemaVersion())
        return RealmManagers()
    }

    private fun initialRealm(context: Context, schema: String, version: Long) {
        // Initial Realm
        Realm.init(context)

        // Initial Realm Configuration
        val configuration: RealmConfiguration = RealmConfiguration.Builder().name(schema).schemaVersion(version).deleteRealmIfMigrationNeeded().build()

        // Set Default Realm Configuration
        Realm.setDefaultConfiguration(configuration)
        Realm.getInstance(configuration)
    }
}