package com.example.madlevel6task2

import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results") var results: List<Movie>
)
