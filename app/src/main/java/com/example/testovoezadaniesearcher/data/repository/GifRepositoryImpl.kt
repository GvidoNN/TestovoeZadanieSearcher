package com.example.testovoezadaniesearcher.data.repository
import com.example.testovoezadaniesearcher.data.api.DataService

import com.example.testovoezadaniesearcher.domain.repository.GifRepository

class GifRepositoryImpl (private val dataService: DataService): GifRepository {
    override fun getAllGifs(text: String) = dataService.getGifs(text)
}