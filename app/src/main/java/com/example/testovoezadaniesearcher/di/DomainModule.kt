package com.example.testovoezadaniesearcher.di

import com.example.testovoezadaniesearcher.domain.usecase.GetDataUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<GetDataUseCase> {
        GetDataUseCase(gifRepository = get())
    }
}