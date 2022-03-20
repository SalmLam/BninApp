package com.example.bnin.di

import androidx.room.Room
import com.example.bnin.db.AppDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "RECIPE"

    /*
    * Class Name  : databaseModule
    * Description : Declares the singleton component of AppDatabase
    * */
val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, DATABASE_NAME)
            .build()
    }
}