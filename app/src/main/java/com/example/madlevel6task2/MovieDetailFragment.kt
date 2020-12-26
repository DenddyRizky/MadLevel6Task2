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
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movie_detail.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMovie()
    }

    private fun showMovie() {
        viewModel.selectedMovie.observe(viewLifecycleOwner, {
            Glide.with(requireContext()).load(it.getBannerUrl()).into(ivBanner)
            Glide.with(requireContext()).load(it.getPosterUrl()).into(ivPoster)
            tvDate.text = it.releaseDate
            tvTitle.text = it.title
            tvRating.text = it.voteAverage.toString()
            tvOverview.text = it.overview
        })
    }
}