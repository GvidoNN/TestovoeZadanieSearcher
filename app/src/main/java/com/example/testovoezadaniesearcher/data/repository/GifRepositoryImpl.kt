package com.example.testovoezadaniesearcher.data.repository
import com.example.testovoezadaniesearcher.data.api.DataService

class GifRepositoryImpl (private val dataService: DataService) {
    fun getAllGifs() = dataService.getGifs("ukraine")
}