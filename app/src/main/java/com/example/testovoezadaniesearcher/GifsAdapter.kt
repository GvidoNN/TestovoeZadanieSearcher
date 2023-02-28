package com.example.testovoezadaniesearcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce

class GifsAdapter(private var gifList: ArrayList<Data>) : RecyclerView.Adapter<GifsAdapter.ViewHolder>() {

    private lateinit var context : Context

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imGif = itemView.findViewById<ImageView>(R.id.imGif)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gif, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gifList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = gifList[position]
        Glide.with(context).load(data.images.original.url).into(holder.imGif)

    }


}
