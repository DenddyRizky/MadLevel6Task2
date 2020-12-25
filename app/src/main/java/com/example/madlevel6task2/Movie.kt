package com.example.madlevel6task2

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var voteAverage: Double,
    @SerializedName("backdrop_path") var backdropPath: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("overview") var overview: String
) {
    fun getBannerUrl() = "https://image.tmdb.org/t/p/w500/$backdropPath"

    fun getPosterUrl() = "https://image.tmdb.org/t/p/w500/$posterPath"
}