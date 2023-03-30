package dev.nhason.lec18_finalproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.nhason.lec18_finalproject.data.dao.MovieDao
import dev.nhason.lec18_finalproject.data.models.Genre
import dev.nhason.lec18_finalproject.data.models.Movie
import dev.nhason.lec18_finalproject.data.models.NewMovie

private const val DB_NAME = "AppDB"
private const val DB_VERSION = 1

@Database(version = DB_VERSION, entities = [Movie::class,Genre::class,NewMovie::class])
abstract class AppDB : RoomDatabase() {
    abstract fun movieDao():MovieDao

    companion object{
        fun create(context: Context) : AppDB{
            return  Room.databaseBuilder(context,AppDB::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}