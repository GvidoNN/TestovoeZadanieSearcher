package com.example.testovoezadaniesearcher.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.data.repository.GifRepositoryImpl
import com.example.testovoezadaniesearcher.domain.usecase.GetDataUseCase

class MainViewModelFactory() : ViewModelProvider.Factory {

    private val gifRepository by lazy { GifRepositoryImpl(dataService = DataService.getInstance()) }
    private val getDataUseCase by lazy { GetDataUseCase(gifRepository = gifRepository) }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getDataUseCase = getDataUseCase
        ) as T

    }
}