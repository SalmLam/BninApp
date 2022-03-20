package com.example.bnin.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/*
  * Class Name  : RecipeEntity
  * Description : Defines the entity Recipe
  * */

@Parcelize
@Entity(tableName = "RECIPE")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title: String,
    val image: String,
    val readyInMinutes : String,
    val glutenFree : Boolean,
    val vegan : Boolean,
    val vegetarian : Boolean,
    val instructions : String,
    val dairyFree : Boolean,
    val veryHealthy : Boolean,
    val healthScore : Int
)  : Parcelable {



}
