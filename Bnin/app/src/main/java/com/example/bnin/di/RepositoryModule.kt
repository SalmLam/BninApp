package com.example.bnin.di

import com.example.bnin.repository.RecipeRepository
import org.koin.dsl.module

    /*
    * Class Name  : repositoryModule
    * Description : Declares the singleton component of RecipeRepository
    * */
val repositoryModule = module {
    single { RecipeRepository(get(), get()) }
}