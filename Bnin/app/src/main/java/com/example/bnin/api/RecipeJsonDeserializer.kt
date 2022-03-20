package com.example.bnin.api

import android.util.Log
import com.example.bnin.db.RecipeEntity
import com.google.gson.*
import java.lang.reflect.Type


    /*
    * Class Name  : RecipeJsonDeserializer
    * Description : Deserializes Json Response into Entity Object
    * */

class RecipeJsonDeserializer : JsonDeserializer<RecipeEntity> {
    companion object {
        const val TITLE = "title"
        const val IMAGE = "image"
        const val READYINMINUTES = "readyInMinutes"
        const val INSTRUCTIONS = "instructions"
        const val GLUTENFREE = "glutenFree"
        const val VEGAN = "vegan"
        const val VERYHEALTHY = "veryHealthy"
        const val VEGETARIAN  = "vegetarian"
        const val DAIRYFREE = "dairyFree"
        const val HEALTHSCORE = "healthScore"

    }

    /*
    * Method Name  : getTimeAsText
    * Description : Converts time (in minutes) from integer type to String type
    * */

    private fun getTimeAsText(readyInMinutes : Int) : String {
        val hour : Int = readyInMinutes / 60
        val minutes : Int = readyInMinutes % 60
        return "$hour:$minutes"
    }

    /*
    * Method Name  : deserialize
    * Description :  Maps Json response sent by APi to the Entity Class Recipe
    * */
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): RecipeEntity {

        val jsonRecipe: JsonObject  = json?.asJsonObject ?: JsonObject()

        val title: String = jsonRecipe
            .get(TITLE)
            .asString

        val image: String = jsonRecipe
            .get(IMAGE)
            .asString

        val readyInMinutes : String = this.getTimeAsText(jsonRecipe
            .get(READYINMINUTES)
            .asInt)

        val glutenFree : Boolean = jsonRecipe
            .get(GLUTENFREE)
            .asBoolean
        val vegan : Boolean = jsonRecipe
            .get(VEGAN)
            .asBoolean
        val vegetarian : Boolean = jsonRecipe
            .get(VEGETARIAN)
            .asBoolean
        val instructions : String = jsonRecipe
            .get(INSTRUCTIONS)
            .asString
        val dairyFree : Boolean = jsonRecipe
            .get(DAIRYFREE)
            .asBoolean
        val veryHealthy : Boolean = jsonRecipe
            .get(VERYHEALTHY)
            .asBoolean
        val healthScore : Int = jsonRecipe
            .get(HEALTHSCORE)
            .asInt

        return RecipeEntity(0,title, image, readyInMinutes, glutenFree, vegan, vegetarian, instructions, dairyFree, veryHealthy, healthScore)

    }
}