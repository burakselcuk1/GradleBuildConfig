package com.example.shortmovieapp.service

import com.example.shortmovieapp.Util.Constans.Companion.API_KEY
import com.example.shortmovieapp.model.Result
import com.example.shortmovieapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("3/movie/upcoming?")
    suspend fun getUpcomingList(
        @Query("api_key")
        apiKey:String=API_KEY
    ): Movie

    @GET("3/movie/now_playing?")
    suspend fun getNowPlayingList(
        @Query("api_key")
        apiKey:String=API_KEY
    ): Response<Movie>

    @GET("3/movie/{movie_id}?")
    suspend fun getMovieDetail(
        @Path("movie_id") id:String,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<Result>
}