package dev.nhason.lec18_finalproject.data.repository

import dev.nhason.lec18_finalproject.data.dao.MovieDao
import dev.nhason.lec18_finalproject.service.TMDBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun refreshMovies(){
        withContext(Dispatchers.IO){
            val service = TMDBService.create()
            val movieRes = service.popularMovies()
            val movieNew = service.newMovies()
            val genreRes = service.genres()
            movieDao.addNewMovie(movieNew.movies)
            movieDao.addMovie(movieRes.movies)
            movieDao.addGenres(genreRes.genres)
        }
    }
}