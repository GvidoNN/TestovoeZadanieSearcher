package com.example.testovoezadaniesearcher.domain.usecase

import com.example.testovoezadaniesearcher.data.repository.GifRepositoryImpl
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import retrofit2.Call

class GetDataUseCase(private val gifRepository: GifRepositoryImpl) {

    fun getData(text: String): Call<DataResponce> {
        return gifRepository.getAllGifs(text = text)
    }
}