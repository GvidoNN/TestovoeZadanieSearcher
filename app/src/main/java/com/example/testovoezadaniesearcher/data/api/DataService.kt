package com.example.testovoezadaniesearcher.data.api

import com.example.testovoezadaniesearcher.domain.model.DataResponce
import retrofit2.http.GET

private const val API_KEY = "Oefcfa7V3FALWqj9lZ4tq4cmquciql9t"

interface DataService {

    @GET("gifs/search?key=$API_KEY&q=ligma&q=20")
    suspend fun getGifs(): retrofit2.Call<DataResponce>
}