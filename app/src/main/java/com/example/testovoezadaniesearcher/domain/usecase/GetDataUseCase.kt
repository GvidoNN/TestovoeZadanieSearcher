package com.example.testovoezadaniesearcher.domain.usecase

import com.example.testovoezadaniesearcher.domain.model.DataResponce
import com.example.testovoezadaniesearcher.domain.repository.GifRepository
import retrofit2.Call

class GetDataUseCase(private val gifRepository: GifRepository) {

    fun getData(text: String): Call<DataResponce> {
        return gifRepository.getAllGifs(text = text)
    }
}