package com.example.testovoezadaniesearcher.domain.repository

import com.example.testovoezadaniesearcher.domain.model.Data

interface GifRepository {

    fun getGifs(): MutableList<Data>
}