package com.example.bnin.di

import com.example.bnin.db.AppDatabase
import org.koin.dsl.module

    /*
    * Class Name  : daoModule
    * Description : Declares the singleton component of RecipeDao
    * */
val daoModule = module {
    single {
        get<AppDatabase>().recipeDao()
    }
}