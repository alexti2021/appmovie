package com.avawm.movieapp.ui.home.repository

import com.avawm.movieapp.data.MovieAppService
import com.avawm.movieapp.data.model.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(
    private val movieAppService: MovieAppService
) {

    suspend fun fetchPopular(apikey: String, page: Int? = null): Response<MoviesResponse> = withContext(
        Dispatchers.IO) {
        val popular = movieAppService.getPopularMovies(apikey, page)
        popular
    }

    suspend fun fetchNomPlaying(apikey: String, page: Int? = null): Response<MoviesResponse> = withContext(
        Dispatchers.IO) {
        val top = movieAppService.getNowPlaying(apikey, page)
        top
    }
}