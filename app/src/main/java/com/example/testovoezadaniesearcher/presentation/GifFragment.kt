package com.example.testovoezadaniesearcher.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testovoezadaniesearcher.R

class GifFragment: Fragment(R.layout.fragment_gif_info) {

    lateinit var imGif : ImageView
    lateinit var tvGifTitle: TextView
    lateinit var tvGifRating: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imGif = requireView().findViewById(R.id.imGifBig)
        tvGifTitle = requireView().findViewById(R.id.tvTitleGif)
        tvGifRating = requireView().findViewById(R.id.tvRatingGif)
        val url = arguments?.getString("url")
        val title = arguments?.getString("title")
        val rating = arguments?.getString("rating")
        Glide.with(requireContext()).load(url).into(imGif)
        tvGifTitle.text = title
        tvGifRating.text = rating
    }
}