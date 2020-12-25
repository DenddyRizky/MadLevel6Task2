package com.example.madlevel6task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withTimeout

class MovieRepository {

    private val movieApiService: MovieApiService = MovieApi.createApi()
    private val _movie: MutableLiveData<Movie> = MutableLiveData()
    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    val movie: LiveData<Movie>
        get() = _movie

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovie(selectedMovie: Movie){
        _movie.value = selectedMovie
    }

    suspend fun getMovies(year: Int) {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                movieApiService.getMovies(year)
            }
            _movies.value = result.results

        } catch (error: Throwable) {
            throw MovieGetError("Unable to get movie list.", error)
        }
    }

    class MovieGetError(message: String, cause: Throwable) : Throwable(message, cause)
}