package dev.nhason.lec18_finalproject

import android.app.Application
import dev.nhason.lec18_finalproject.data.AppDB
import dev.nhason.lec18_finalproject.data.repository.MovieRepository

class TMDApp : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        db = AppDB.create(this)
        movieRepository = MovieRepository(db.movieDao())
    }

    companion object {
        lateinit var app: TMDApp
        lateinit var db: AppDB
        lateinit var movieRepository: MovieRepository
    }
}