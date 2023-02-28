package com.example.testovoezadaniesearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val gifsList = mutableListOf<Data>()
        val adapter = GifsAdapter(gifList = gifsList as ArrayList<Data>)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this,2)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        val retroService = retrofit.create(DataService::class.java)



        retroService.getGifs().enqueue(object : Callback<DataResponce>{
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

    companion object {
        const val BASE_URL= "https://api.giphy.com/v1/"
    }
}