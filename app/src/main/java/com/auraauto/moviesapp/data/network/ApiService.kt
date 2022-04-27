package com.auraauto.moviesapp.data.network

import com.auraauto.moviesapp.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/shows")
    suspend fun getAllMovies(): Response<List<Movies>>
}