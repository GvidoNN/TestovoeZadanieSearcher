package com.example.testovoezadaniesearcher.data.api

import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val API_KEY = "Oefcfa7V3FALWqj9lZ4tq4cmquciql9t"

interface DataService {
    @GET("gifs/search?key=$API_KEY&limit=20")
    fun getGifs(@Query("q") text: String): retrofit2.Call<DataResponce>

}