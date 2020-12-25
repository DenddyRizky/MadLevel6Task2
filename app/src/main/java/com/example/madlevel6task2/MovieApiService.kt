package com.example.madlevel6task2

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "cdcf101a73bdc4081aa17d52d3ef799e"

interface MovieApiService {

    @GET("discover/movie?api_key=$API_KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    suspend fun getMovies(@Query("year") year: Int): MovieList
}