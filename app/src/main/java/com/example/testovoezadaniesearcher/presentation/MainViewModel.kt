package com.example.testovoezadaniesearcher.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testovoezadaniesearcher.data.repository.GifRepositoryImpl
import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import com.example.testovoezadaniesearcher.domain.repository.GifRepository

class MainViewModel : ViewModel() {

    val gifRepository by lazy {GifRepositoryImpl()}

//    fun getGif() : MutableLiveData<List<Data>> = gifRepository.getGifs()
}