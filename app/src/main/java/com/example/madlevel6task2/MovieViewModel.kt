package com.example.madlevel6task2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository = MovieRepository()
    private var _selectedMovie: MutableLiveData<Movie> = MutableLiveData()
    val movies = movieRepository.movies

    val selectedMovie: LiveData<Movie>
        get() = _selectedMovie

    private val _errorText: MutableLiveData<String> = MutableLiveData()
    val errorText: LiveData<String>
        get() = _errorText

    fun getMovies(year: Int){
        viewModelScope.launch {
            try {
                movieRepository.getMovies(year)
            } catch (error: Throwable){
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }
        }
    }

    fun setMovie(movie: Movie){
        _selectedMovie.value = movie
        Log.d("MOVIEE", _selectedMovie.value.toString())
    }
}