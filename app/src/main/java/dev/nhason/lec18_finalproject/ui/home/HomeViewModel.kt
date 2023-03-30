package dev.nhason.lec18_finalproject.ui.home

import android.app.Application
import androidx.lifecycle.*
import dev.nhason.lec18_finalproject.TMDApp
import dev.nhason.lec18_finalproject.data.AppDB
import dev.nhason.lec18_finalproject.data.models.Genre
import dev.nhason.lec18_finalproject.data.models.Movie
import dev.nhason.lec18_finalproject.data.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val movies : LiveData<List<Movie>> = TMDApp.db.movieDao().getMovies()
//    val genre : LiveData<List<Genre>> = TMDApp.db.movieDao().getGenres()

    init {
        viewModelScope.launch {
            TMDApp.movieRepository.refreshMovies()
        }
    }

}