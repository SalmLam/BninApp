package com.example.bnin.di

import com.example.bnin.api.RecipeJsonDeserializer
import com.example.bnin.db.RecipeEntity
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import java.lang.reflect.Modifier

    /*
    * Class Name  : jsonModule
    * Description : Registers the registerTypeAdapter of Gson -> RecipeJsonDeserializer
    * */
val jsonModule = module {
    single {
        GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
            .serializeNulls()
            .registerTypeAdapter(RecipeEntity::class.java, RecipeJsonDeserializer())
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }
}