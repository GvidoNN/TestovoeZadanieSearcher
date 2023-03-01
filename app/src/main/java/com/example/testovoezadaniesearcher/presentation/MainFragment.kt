package com.example.testovoezadaniesearcher.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testovoezadaniesearcher.GifsAdapter
import com.example.testovoezadaniesearcher.R
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFragment: Fragment(R.layout.fragment_main) {

    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        recyclerView = requireView().findViewById(R.id.recyclerView)

        val gifsList = mutableListOf<Data>()
        val adapter = GifsAdapter(gifList = gifsList as ArrayList<Data>)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(
            GsonConverterFactory.create()).build()

        val retroService = retrofit.create(DataService::class.java)

        fun responce(){
            retroService.getGifs("ligma").enqueue(object : Callback<DataResponce> {
                override fun onResponse(call: Call<DataResponce>, response: Response<DataResponce>) {
                    val body = response.body()
                    if (body == null) {
                        Log.d("MyLog","No responce")
                    }
                    gifsList.addAll(body!!.res)
                    adapter.notifyDataSetChanged()

                }

                override fun onFailure(call: Call<DataResponce>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }

        CoroutineScope(Dispatchers.IO).launch {
            responce()
        }

    }

    companion object {
        const val BASE_URL= "https://api.giphy.com/v1/"

    }
}