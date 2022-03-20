package com.example.bnin.db

import androidx.room.Database
import androidx.room.RoomDatabase

/*
  * Class Name  : AppDatabase
  * Description : Creates the database
  * */

@Database(entities = [RecipeEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun recipeDao(): RecipeDao
}