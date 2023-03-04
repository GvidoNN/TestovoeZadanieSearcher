package com.example.testovoezadaniesearcher.data.api

import com.example.testovoezadaniesearcher.domain.model.DataResponce
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "Oefcfa7V3FALWqj9lZ4tq4cmquciql9t"
private const val BASE_URL = "https://api.giphy.com/v1/"

interface DataService {
    @GET("gifs/search?key=$API_KEY&limit=25")
    fun getGifs(@Query("q") text: String): retrofit2.Call<DataResponce>

  companion object {
        var retrofitService: DataService? = null

        fun getInstance() : DataService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(DataService::class.java)
            }
            return retrofitService!!
        }
    }
}