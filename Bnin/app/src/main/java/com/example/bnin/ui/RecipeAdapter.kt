package com.example.bnin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bnin.R
import com.example.bnin.db.RecipeEntity

    /*
    * Class Name  : RecipeAdapter
    * Description : The adapter that adapts data to be displayed in Recycler View
    * */

class RecipeAdapter(private val recipeEntities: List<RecipeEntity>, private val recipeNameListener : OnRecipeNameListener) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // inflates the recipe_card that holds the recipe items
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_card, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // gets recipe instance
        val recipe = recipeEntities[position]

        // sets the onClickListener of recipeName and recipeImage
        holder.recipeName.setOnClickListener {
            recipeNameListener.onRecipeNameClicked(recipe)
        }
        holder.recipeImage.setOnClickListener {
            recipeNameListener.onRecipeNameClicked(recipe)
        }

        // sets the values of each component of the itemHolder
        holder.recipeName.text = recipe.title
        holder.recipeTime.text = "Ready in: ${recipe.readyInMinutes}"
        holder.recipeHealthScore.text = "Nutritional score: ${recipe.healthScore}%"
        Glide.with(holder.itemView.getContext())
            .load(recipe.image)
            .override(100, 200)
            .fitCenter() // scale to fit entire image within ImageView
            .into(holder.recipeImage);

    }


    override fun getItemCount(): Int {
        // gets the number of items
        return recipeEntities.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //bind the components of the recipe card to the holder
        val recipeName: TextView = itemView.findViewById(R.id.recipe_name)
        val recipeHealthScore: TextView = itemView.findViewById(R.id.health_score)
        val recipeTime : TextView = itemView.findViewById(R.id.recipe_time)
        val recipeImage : ImageView = itemView.findViewById(R.id.recipe_image)
    }

    interface OnRecipeNameListener {
        fun onRecipeNameClicked (recipeEntity : RecipeEntity)
    }
}