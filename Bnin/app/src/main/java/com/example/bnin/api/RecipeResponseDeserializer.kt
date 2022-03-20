package com.example.bnin.api

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

    /*
    * Class Name  : RecipeResponseDeserializer
    * Description : Maps Json response sent by APi to an object of Type RecipeResult
    * */
class RecipeResponseDeserializer (private var gson: Gson) : ResponseDeserializable<RecipeResult> {

    /*
    * Method Name  : deserialize
    * Description :  Converts Json content string to RecipeResult
    * */
    override fun deserialize(content: String): RecipeResult {
        return gson.fromJson(content, RecipeResult::class.java);
    }
}
