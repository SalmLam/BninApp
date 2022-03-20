package com.example.bnin.repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import awaitObjectResult
import com.example.bnin.api.RecipeResponseDeserializer
import com.example.bnin.api.RecipeRouting
import com.example.bnin.db.RecipeEntity
import com.example.bnin.db.RecipeDao
import com.github.kittinunf.fuel.Fuel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch

    /*
    * Class Name  : RecipeRepository
    * Description : Manages access to multiple data sources
    * */
class RecipeRepository constructor(
    private val recipeDao: RecipeDao,
    private val recipeResponseDeserializer: RecipeResponseDeserializer
) {
    private val _recipes = MediatorLiveData<Resource<Array<RecipeEntity>>>()
    val recipes: LiveData<Resource<Array<RecipeEntity>>>
        get() {
            return _recipes
        }

    init {
        subscribeToDatabase()
    }

     /*
    * Class Name  : subscribeToDatabase
    * Description : Manages subscription to database
    * */
    private fun subscribeToDatabase() {
        val sourceDb = recipeDao.getAll()
        _recipes.postValue(Resource.loading(emptyArray()))

        _recipes.addSource(sourceDb) {
            _recipes.postValue(Resource.success(it))
        }
    }

        /*
        * Method Name  : CoroutineScope.getRecipes()
        * Description : Defines the producerScope
        * */
    private fun CoroutineScope.getRecipes() = produce {

        val lastData: Array<RecipeEntity> = recipes.value?.data ?: emptyArray()
        send(Resource.loading(lastData))

        Fuel.request(RecipeRouting.GetRecipes())
            .awaitObjectResult(recipeResponseDeserializer)
            .fold(success = { response ->
                recipeDao.clearAll()
                recipeDao.insertAll(response.data)
            }, failure = { error ->
                send(Resource.error(error, lastData))
            })
    }

        /*
        * Method Name  : fetchRecipes()
        * Description : launches the producerScope
        * */

    fun fetchRecipes() = GlobalScope.launch {
        for (recipe in getRecipes()) {
            _recipes.postValue(recipe)
        }
    }
}