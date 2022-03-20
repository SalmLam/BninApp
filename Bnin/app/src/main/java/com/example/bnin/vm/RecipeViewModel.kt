package com.example.bnin.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bnin.db.RecipeEntity
import com.example.bnin.repository.RecipeRepository
import com.example.bnin.repository.Resource

/*
    * Class Name  : RecipeViewModel
    * Description : The ViewModel that prepares recipes data to be displayed in the view
    * */
class RecipeViewModel constructor(
    private val recipeRepository: RecipeRepository
): ViewModel() {
    val recipes: LiveData<Resource<Array<RecipeEntity>>> = recipeRepository.recipes

    fun fetchRecipes() {
        recipeRepository.fetchRecipes()
    }
}

