package com.example.testovoezadaniesearcher.domain.repository

import com.example.testovoezadaniesearcher.domain.model.DataResponce
import retrofit2.Call

interface GifRepository {
    fun getAllGifs(text: String): Call<DataResponce>

}