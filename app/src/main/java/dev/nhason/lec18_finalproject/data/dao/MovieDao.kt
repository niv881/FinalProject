package dev.nhason.lec18_finalproject.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.nhason.lec18_finalproject.data.models.Genre
import dev.nhason.lec18_finalproject.data.models.Movie
import dev.nhason.lec18_finalproject.data.models.NewMovie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(movie : Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movie : List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(movie : NewMovie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewMovie(movie: List<NewMovie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(genres : Genre)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGenres(genres : List<Genre>)

    @Query("SELECT * FROM Movie ")
    fun getMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM Genre ")
    fun getGenres(): LiveData<List<Genre>>

    @Query("SELECT * FROM NewMovie ORDER BY releaseDate ")
    fun getNewMovies() : LiveData<List<NewMovie>>

}