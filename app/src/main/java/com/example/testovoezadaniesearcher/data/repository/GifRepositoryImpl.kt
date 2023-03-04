package com.example.testovoezadaniesearcher.data.repository

import android.net.ConnectivityDiagnosticsManager.DataStallReport
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testovoezadaniesearcher.GifsAdapter
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import com.example.testovoezadaniesearcher.domain.usecase.CheckInterceptorUseCase
import com.example.testovoezadaniesearcher.presentation.MainFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GifRepositoryImpl {

    val checkInterceptorUseCase by lazy{CheckInterceptorUseCase()}


    fun getGifs(){

        var gifsList = MutableLiveData<List<Data>>()

        val retrofit = Retrofit.Builder().baseUrl(MainFragment.BASE_URL).client(checkInterceptorUseCase.getClient()).addConverterFactory(
            GsonConverterFactory.create()).build()

        val retroService = retrofit.create(DataService::class.java)

        retroService.getGifs("ukraine").enqueue(object : Callback<DataResponce> {
            override fun onResponse(call: Call<DataResponce>, response: Response<DataResponce>) {
                val body = response.body()
                if (body == null) {
                    Log.d("MyLog","No responce")
                }
//                gifsList.addAll(body!!.res)

                Log.d("MyLog"," in responce $gifsList")
            }

            override fun onFailure(call: Call<DataResponce>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}