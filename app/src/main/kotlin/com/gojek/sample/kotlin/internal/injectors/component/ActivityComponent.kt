package com.gojek.sample.kotlin.internal.injectors.component

import android.content.Context
import com.gojek.sample.kotlin.internal.injectors.module.ActivityModule
import com.gojek.sample.kotlin.internal.injectors.scope.ActivityContext
import com.gojek.sample.kotlin.internal.injectors.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent {

    @ActivityContext
    fun getContext(): Context
}