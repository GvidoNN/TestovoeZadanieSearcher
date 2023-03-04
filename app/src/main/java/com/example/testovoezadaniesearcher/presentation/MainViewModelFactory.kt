package com.example.testovoezadaniesearcher.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.data.repository.GifRepositoryImpl
import com.example.testovoezadaniesearcher.domain.usecase.GetDataUseCase
import com.example.testovoezadaniesearcher.domain.usecase.GetTextSearchUseCase

//class MainViewModelFactory: ViewModelProvider.Factory {
//    private val getTextSearchUseCase by lazy(LazyThreadSafetyMode.NONE) { GetTextSearchUseCase() }
//    private val gifRepository by lazy{GifRepositoryImpl(dataService = DataService.getInstance())}
//    private val getDataUseCase by lazy{GetDataUseCase(gifRepository = gifRepository)}
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            MainViewModel(
//                getTextSearchUseCase = getTextSearchUseCase,
//                getDataUseCase = getDataUseCase
//            ) as T
//        } else {
//            throw IllegalArgumentException("ViewModel Not Found")
//        }
//    }
//}

class MainViewModelFactory() : ViewModelProvider.Factory {

    private val getTextSearchUseCase by lazy(LazyThreadSafetyMode.NONE) { GetTextSearchUseCase() }
    private val gifRepository by lazy { GifRepositoryImpl(dataService = DataService.getInstance()) }
    private val getDataUseCase by lazy { GetDataUseCase(gifRepository = gifRepository) }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getTextSearchUseCase = getTextSearchUseCase,
            getDataUseCase = getDataUseCase
        ) as T

    }
}