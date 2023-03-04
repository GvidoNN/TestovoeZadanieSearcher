package com.example.testovoezadaniesearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun <T : Any?> MutableLiveData<ArrayList<T>>.default(initialValue: ArrayList<T>) = apply { setValue(initialValue) }

}