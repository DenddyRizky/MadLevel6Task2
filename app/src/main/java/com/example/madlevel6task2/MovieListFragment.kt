package com.example.madlevel6task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_movie_list.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieListFragment : Fragment() {

    private val movies = arrayListOf<Movie>()
    private val viewModel: MovieViewModel by activityViewModels()
    private val movieAdapter = MovieAdapter(movies, ::onMovieClick)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMovies.adapter = movieAdapter

        //movieAdapter = MovieAdapter(movies, this::onMovieClick)
        rvMovies.layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)

        btSubmit.setOnClickListener{
            viewModel.getMovies(etYear.text.toString().toInt())
        }
        observeMovies()
    }

    private fun onMovieClick(movie: Movie){
        viewModel.setMovie(movie)
        Log.d("MOVIEE", movie.toString())
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            movies.clear()
            movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })
    }
}