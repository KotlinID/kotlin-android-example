package com.gojek.sample.kotlin.internal.injectors.module

import com.gojek.sample.kotlin.extensions.baseUrl
import com.gojek.sample.kotlin.extensions.getInterceptor
import com.gojek.sample.kotlin.internal.data.remote.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
        val retrofit: Retrofit = Retrofit.Builder().client(getOkHttpClient())
                                                   .baseUrl(baseUrl())
                                                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                                   .addConverterFactory(JacksonConverterFactory.create())
                                                   .build()
        return retrofit.create(Api::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                                     .readTimeout(15, TimeUnit.SECONDS)
                                     .writeTimeout(15, TimeUnit.SECONDS)
                                     .retryOnConnectionFailure(true)
                                     .addInterceptor(getInterceptor())
                                     .addInterceptor(httpLoggingInterceptor)
                                     .build()
    }
}