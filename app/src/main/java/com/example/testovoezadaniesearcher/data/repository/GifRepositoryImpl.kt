package com.example.testovoezadaniesearcher.data.repository
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import retrofit2.Call

//class GifRepositoryImpl (private val dataService: DataService): GifRepository {

//    override fun getAllGifs(text: String): Call<DataResponce> {
//        return dataService.getGifs(text)
//    }

//}

class GifRepositoryImpl (private val dataService: DataService) {
    fun getAllGifs(text: String) = dataService.getGifs(text)
}