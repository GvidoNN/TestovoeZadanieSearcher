package com.example.testovoezadaniesearcher.di

import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.data.repository.GifRepositoryImpl
import com.example.testovoezadaniesearcher.domain.repository.GifRepository
import org.koin.dsl.module

val dataModule = module {
    single<GifRepository> {
        GifRepositoryImpl(dataService = DataService.getInstance())
    }
}