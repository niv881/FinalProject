package dev.nhason.lec18_finalproject.data.models


import com.google.gson.annotations.SerializedName

data class NewMovieResponse(
    val page: Int,
    @SerializedName("results")
    val movies: List<NewMovie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)