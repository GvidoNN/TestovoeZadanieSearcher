package com.example.testovoezadaniesearcher.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testovoezadaniesearcher.GifsAdapter
import com.example.testovoezadaniesearcher.R
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.data.repository.GifRepositoryImpl
import com.example.testovoezadaniesearcher.domain.model.Data
import com.example.testovoezadaniesearcher.domain.model.DataResponce
import com.example.testovoezadaniesearcher.domain.usecase.CheckInterceptorUseCase
import com.example.testovoezadaniesearcher.domain.usecase.GetTextSearchUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class

MainFragment: Fragment(R.layout.fragment_main) {

//    lateinit var recyclerView: RecyclerView
//    lateinit var bundle: Bundle
//    val checkInterceptorUseCase by lazy { CheckInterceptorUseCase() }
//    lateinit var btSearch: ImageButton
//    lateinit var edSearch: EditText
//    lateinit var adapter: GifsAdapter
//    val getTextSearchUseCase by lazy { GetTextSearchUseCase() }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        recyclerView = requireView().findViewById(R.id.recyclerView)
//        btSearch = requireView().findViewById(R.id.btSearch)
//        edSearch = requireView().findViewById(R.id.edSearchGif)
//
//        val gifsList = mutableListOf<Data>()
//        val adapter = GifsAdapter(gifList = gifsList as ArrayList<Data>)
//
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
//
//        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(checkInterceptorUseCase.getClient()).addConverterFactory(
//            GsonConverterFactory.create()).build()
//
//        val retroService = retrofit.create(DataService::class.java)
//
//        fun responce(){
//            val text = edSearch.text.toString()
//            retroService.getGifs(getTextSearchUseCase.showData(text)).enqueue(object : Callback<DataResponce> {
//                override fun onResponse(call: Call<DataResponce>, response: Response<DataResponce>) {
//                    val body = response.body()
//                    if (body == null) {
//                        Log.d("MyLog","No responce")
//                    }
//                    gifsList.addAll(body!!.res)
//                    adapter.notifyDataSetChanged()
//                }
//
//                override fun onFailure(call: Call<DataResponce>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//
//        }
//
//        btSearch.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                responce()
//            }
//        }
//
//
//        adapter.setOnItemClickListener(object: GifsAdapter.OnItemClickListener{
//
//            override fun onItemClick(position: Int) {
//                bundle = Bundle()
//                bundle.putString("url", gifsList[position].images.original.url)
//                bundle.putString("title", gifsList[position].title)
//                bundle.putString("rating",gifsList[position].rating)
//                findNavController().navigate(R.id.action_mainFragment_to_gifFragment, bundle)
//
//            }
//
//        })
//
//    }
//
//    companion object {
//        const val BASE_URL= "https://api.giphy.com/v1/"
//    }

    private val TAG = "MainActivity"
    private lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel
    private val dataService = DataService.getInstance()
    lateinit var bundle: Bundle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = requireView().findViewById(R.id.recyclerView)
        val adapter = GifsAdapter()

        viewModel = ViewModelProvider(requireActivity(), MainViewModelFactory(GifRepositoryImpl(dataService))).get(MainViewModel::class.java)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        viewModel.gifList.observe(viewLifecycleOwner) {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) {
        }
        viewModel.getAllMovies()

        adapter.setOnItemClickListener(object: GifsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                bundle = Bundle()
                Log.d("MyLog","${adapter.gifList[position].images.original.url}")
                bundle.putString("url", adapter.gifList[position].images.original.url)
                bundle.putString("title", adapter.gifList[position].title)
                bundle.putString("rating", adapter.gifList[position].rating)
                findNavController().navigate(R.id.action_mainFragment_to_gifFragment, bundle)

                   }
        })
    }
}

