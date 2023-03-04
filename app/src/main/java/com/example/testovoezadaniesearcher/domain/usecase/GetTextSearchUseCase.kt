package com.example.testovoezadaniesearcher.domain.usecase

import android.util.Log

class GetTextSearchUseCase() {

    private lateinit var textForRequest: String

    fun showData(text: String): String {
        Log.d("MyLog", "ShowData UseCase")
        textForRequest = text.replace(" ", "%20")
        textForRequest = textForRequest.replace("\n", "%20")
        return textForRequest
    }
}