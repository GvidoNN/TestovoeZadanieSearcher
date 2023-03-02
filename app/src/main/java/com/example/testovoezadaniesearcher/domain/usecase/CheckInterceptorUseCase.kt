package com.example.testovoezadaniesearcher.domain.usecase

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class CheckInterceptorUseCase {

    fun getClient(): OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return client
    }
}