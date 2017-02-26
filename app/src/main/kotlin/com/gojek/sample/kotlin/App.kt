package com.gojek.sample.kotlin

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.gojek.sample.kotlin.internal.injectors.component.ApplicationComponent
import com.gojek.sample.kotlin.internal.injectors.component.DaggerApplicationComponent
import com.gojek.sample.kotlin.internal.injectors.module.ApplicationModule
import com.gojek.sample.kotlin.internal.injectors.module.NetworkModule
import com.gojek.sample.kotlin.internal.injectors.module.RealmModule

class App : Application() {

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this))
                                                        .networkModule(NetworkModule())
                                                        .realmModule(RealmModule(this))
                                                        .build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}