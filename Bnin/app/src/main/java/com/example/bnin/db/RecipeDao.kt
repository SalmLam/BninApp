package com.example.bnin.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/*
  * Class Name  : RecipeDao
  * Description : Defines the requests to the database
  * */

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(recipeEntities: Array<RecipeEntity>)

    @Query("SELECT * FROM RECIPE ")
    fun getAll(): LiveData<Array<RecipeEntity>>

    @Query("DELETE FROM RECIPE")
    fun clearAll()
}