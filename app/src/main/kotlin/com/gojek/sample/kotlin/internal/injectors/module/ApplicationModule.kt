package com.gojek.sample.kotlin.internal.injectors.module

import android.app.Application
import android.content.Context
import com.gojek.sample.kotlin.internal.injectors.scope.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule constructor(private val application: Application) {

    @Provides
    fun provideApplication(): Application = application

    @Provides
    @ApplicationContext
    fun provideApplicationContext(): Context = application
}