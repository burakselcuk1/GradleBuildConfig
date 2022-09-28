package com.example.shortmovieapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shortmovieapp.Util.Resource
import com.example.shortmovieapp.Util.Resource.Success
import com.example.shortmovieapp.adapter.MovieAdapter
import com.example.shortmovieapp.adapter.NowPlayingAdapter
import com.example.shortmovieapp.databinding.FragmentMainPageBinding
import com.example.shortmovieapp.model.Movie
import com.example.shortmovieapp.viewModel.MainPageViewModel


class MainPageFragment : Fragment() {

    private var _binding : FragmentMainPageBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MovieAdapter
    private lateinit var nowPlayingAdapter: NowPlayingAdapter
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentMainPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        provideViewModel()
        getMovies()

    }
    private fun provideViewModel() {
        viewModel = ViewModelProvider(requireActivity()).get(MainPageViewModel::class.java)
    }
    private fun getMovies() {
        viewModel.movie.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    adapter = MovieAdapter(it.data)
                    binding.verticalRecyclerview.layoutManager = LinearLayoutManager(context)
                    binding.verticalRecyclerview.adapter = adapter
                }
            }
        })
    }

}