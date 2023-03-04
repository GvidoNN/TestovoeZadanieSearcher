package com.example.testovoezadaniesearcher.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import com.example.testovoezadaniesearcher.domain.usecase.GetDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    val gifList = MutableLiveData<List<Data>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllGifs(text: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = getDataUseCase.getData(text = text)
            response.enqueue(object : Callback<DataResponce> {
                override fun onResponse(call: Call<DataResponce>, response: Response<DataResponce>) {
                    val body = response.body()
                    Log.d("MyLog", "$gifList")
                    if (body != null) {
                        gifList.postValue(body.res)
                    }
                }

                override fun onFailure(call: Call<DataResponce>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })

        }

    }


}