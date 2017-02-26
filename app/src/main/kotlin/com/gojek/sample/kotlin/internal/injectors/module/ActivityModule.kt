package com.gojek.sample.kotlin.internal.injectors.module

import android.app.Activity
import android.content.Context
import com.gojek.sample.kotlin.internal.injectors.scope.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(private val activity: Activity) {

    @Provides
    fun provideActivity(): Activity = activity

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context = activity
}