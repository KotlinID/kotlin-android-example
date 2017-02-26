package com.gojek.sample.kotlin.extensions

import com.gojek.sample.kotlin.BuildConfig

internal fun baseUrl(): String = BuildConfig.ENDPOINT

internal fun realmSchema(): String = "phonebook.realm"

internal fun realmSchemaVersion(): Long = 1L