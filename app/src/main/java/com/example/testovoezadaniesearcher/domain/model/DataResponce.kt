package com.example.testovoezadaniesearcher.domain.model

import com.google.gson.annotations.SerializedName

data class DataResponce(
    @SerializedName("data")
    val res: List<Data>
)