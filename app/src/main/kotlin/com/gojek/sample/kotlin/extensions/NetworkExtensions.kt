package com.gojek.sample.kotlin.extensions

import okhttp3.Interceptor
import okhttp3.Request

internal fun getInterceptor(): Interceptor {
    return Interceptor { chain ->
        val request: Request = chain.request()
        val builder: Request.Builder = request.newBuilder().addHeader("Content-Type", "application/json")

        chain.proceed(builder.build())
    }
}