package com.example.madlevel6task2

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("rating") var rating: Double,
    @SerializedName("banner") var banner: String,
    @SerializedName("poster") var poster: String,
    @SerializedName("text") var text: String
) {
    fun getBannerUrl() = "https://image.tmdb.org/t/p/w500/$banner"

    fun getPosterUrl() = "https://image.tmdb.org/t/p/w500/$poster"
}