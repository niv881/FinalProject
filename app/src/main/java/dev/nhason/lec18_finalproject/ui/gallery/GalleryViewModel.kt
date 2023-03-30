package dev.nhason.lec18_finalproject.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.nhason.lec18_finalproject.TMDApp
import dev.nhason.lec18_finalproject.data.models.Genre
import dev.nhason.lec18_finalproject.data.models.NewMovie
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    val movies : LiveData<List<NewMovie>> = TMDApp.db.movieDao().getNewMovies()

    init {
        viewModelScope.launch {
            TMDApp.movieRepository.refreshMovies()
        }
    }

}