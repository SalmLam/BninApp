package com.example.bnin.di

import com.example.bnin.api.RecipeResponseDeserializer
import org.koin.dsl.module


    /*
    * Class Name  : deserializerModule
    * Description : Declares the singleton component of RecipeResponseDeserializer
    * */
val deserializerModule = module {
    single { RecipeResponseDeserializer(get()) }
}