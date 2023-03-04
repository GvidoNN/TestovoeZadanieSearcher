package com.example.testovoezadaniesearcher.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testovoezadaniesearcher.GifsAdapter
import com.example.testovoezadaniesearcher.R
import com.example.testovoezadaniesearcher.data.api.DataService
import com.example.testovoezadaniesearcher.data.repository.GifRepositoryImpl
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment: Fragment(R.layout.fragment_main) {

    //    private lateinit var recyclerView: RecyclerView
////    val viewModel by viewModel<MainViewModel>()
//    lateinit var viewModel: MainViewModel
//    lateinit var btSearch: ImageButton
//    lateinit var edSearch: EditText
////    private val dataService = DataService.getInstance()
//    lateinit var bundle: Bundle
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        btSearch = requireView().findViewById(R.id.btSearch)
//        edSearch = requireView().findViewById(R.id.edSearchGif)
//        recyclerView = requireView().findViewById(R.id.recyclerView)
//        val adapter = GifsAdapter()
//
//        viewModel = ViewModelProvider(requireActivity(), MainViewModelFactory()).get(MainViewModel::class.java)
//
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
//
//        btSearch.setOnClickListener {
//            val textSearch = edSearch.text.toString()
//            viewModel.gifList.observe(viewLifecycleOwner) {
//                adapter.setMovieList(it)
//            }
//            viewModel.errorMessage.observe(viewLifecycleOwner) {
//            }
//            viewModel.getAllGifs(text = textSearch)
//        }
//
//
//        adapter.setOnItemClickListener(object: GifsAdapter.OnItemClickListener {
//            override fun onItemClick(position: Int) {
//                bundle = Bundle()
//                bundle.putString("url", adapter.gifList[position].images.original.url)
//                bundle.putString("title", adapter.gifList[position].title)
//                bundle.putString("rating", adapter.gifList[position].rating)
//                findNavController().navigate(R.id.action_mainFragment_to_gifFragment, bundle)
//            }
//        })
//    }
    private lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel
//    private val dataService = DataService.getInstance()
    lateinit var bundle: Bundle
    lateinit var btSearch: ImageButton
    lateinit var edSearch: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btSearch = requireView().findViewById(R.id.btSearch)
        edSearch = requireView().findViewById(R.id.edSearchGif)

        recyclerView = requireView().findViewById(R.id.recyclerView)
        val adapter = GifsAdapter()

        viewModel = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory()
        ).get(MainViewModel::class.java)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        btSearch.setOnClickListener {
            val textSearch = edSearch.text.toString()
            viewModel.gifList.observe(viewLifecycleOwner) {
                adapter.setMovieList(it)
            }
            viewModel.errorMessage.observe(viewLifecycleOwner) {
            }
            viewModel.getAllGifs(text = textSearch)
            adapter.setOnItemClickListener(object : GifsAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    bundle = Bundle()
                    bundle.putString("url", adapter.gifList[position].images.original.url)
                    bundle.putString("title", adapter.gifList[position].title)
                    bundle.putString("rating", adapter.gifList[position].rating)
                    findNavController().navigate(R.id.action_mainFragment_to_gifFragment, bundle)

                }
            })
        }
    }
}
//}

