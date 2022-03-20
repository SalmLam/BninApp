package com.example.bnin.api

import com.example.bnin.db.RecipeEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

    /*
   * Class Name  : RecipeResult
   * Description : Manages the Array of Recipe Entities
   * */
data class RecipeResult (
        @Expose
        @SerializedName("recipes")
        val data: Array<RecipeEntity>
    ) {

        /*
        * Method Name  : equals
        * Description : Overrides the operator equals
        * */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecipeResult

        if (!Arrays.equals(data, other.data)) return false

        return true
    }

        /*
        * Method Name  : hashCode
        * Description : Overrides the hashCode Function
        * */
    override fun hashCode(): Int {
        return Arrays.hashCode(data)
    }
}