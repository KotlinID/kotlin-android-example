package com.gojek.sample.kotlin.internal.injectors.module

import android.content.Context
import com.gojek.sample.kotlin.extensions.initialRealm
import com.gojek.sample.kotlin.extensions.realmSchema
import com.gojek.sample.kotlin.extensions.realmSchemaVersion
import com.gojek.sample.kotlin.internal.data.local.RealmManagers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RealmModule constructor(private val context: Context) {

    @Provides
    @Singleton
    fun provideRealmManagers(): RealmManagers {
        initialRealm(context, realmSchema(), realmSchemaVersion())
        return RealmManagers()
    }
}