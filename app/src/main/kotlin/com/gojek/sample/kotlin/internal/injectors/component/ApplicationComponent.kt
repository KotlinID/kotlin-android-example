package com.gojek.sample.kotlin.internal.injectors.component

import android.app.Application
import android.content.Context
import com.gojek.sample.kotlin.internal.data.local.RealmManagers
import com.gojek.sample.kotlin.internal.data.remote.Api
import com.gojek.sample.kotlin.internal.injectors.module.ApplicationModule
import com.gojek.sample.kotlin.internal.injectors.module.NetworkModule
import com.gojek.sample.kotlin.internal.injectors.module.RealmModule
import com.gojek.sample.kotlin.internal.injectors.scope.ApplicationContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        RealmModule::class
))
interface ApplicationComponent {

    @ApplicationContext
    fun getContext(): Context

    fun inject(application: Application)

    fun getApi(): Api

    fun getRealmManagers(): RealmManagers
}