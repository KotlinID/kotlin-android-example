package com.gojek.sample.kotlin.extensions

internal inline fun <reified T : Any> membersOf() = T::class.java