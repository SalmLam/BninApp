package com.example.bnin.api

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting


/*
  * Class Name  : RecipeRouting
  * Description : Defines the route for a Get request to the endpoint /random of the api https://api.spoonacular.com/recipes with two param number = 20
  * */
sealed class RecipeRouting : FuelRouting{

    override val basePath = "https://api.spoonacular.com/recipes";

    /*
    * Class Name  : GetRecipes
    * Description : extends RecipeRouting
    * */
    class GetRecipes(
        override val bytes: ByteArray? = ByteArray(0),
        override val body: String? = "") : RecipeRouting()

    /*
    * Method Name  : Method
    * Description : Defines the Method of the request => GET
    * */
    override val method: Method
        get() {
            when(this) {
                is GetRecipes -> return Method.GET
            }
        }

    /*
   * Method Name  : path
   * Description : Defines the path to the endpoint
   * */
    override val path: String
        get() {

            return when(this) {

                is GetRecipes -> "https://api.spoonacular.com/recipes/random?apiKey=558df680280a4129806a01b6de52bd85&number=20"
            }
        }

    /*
  * Method Name  : params
  * Description : Defines the params of the request
  * */
    override val params: List<Pair<String, Any?>>?
        get() {
           return null
        }

    /*
  * Method Name  : headers
  * Description : Defines the headers of the request
  * */
    override val headers: Map<String, String>?
        get() {
            return null
        }
}
