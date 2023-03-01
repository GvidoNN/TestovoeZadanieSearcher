package com.example.testovoezadaniesearcher.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testovoezadaniesearcher.R

class GifFragment: Fragment(R.layout.fragment_gif_info) {

    lateinit var imGif : ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imGif = requireView().findViewById(R.id.imGifBig)
        val imageView = arguments?.getString("url")
        Log.d("MyLog","$imageView")
        Glide.with(requireContext()).load(imageView).into(imGif)
    }
}