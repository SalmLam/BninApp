package com.example.bnin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.bnin.R
import com.example.bnin.db.RecipeEntity

/*
    * Class Name  : RecipeDetailsFragment
    * Description : The fragment that displays details about each recipe
    * */


class RecipeDetailsFragment : Fragment() {

    lateinit var recipeEntity : RecipeEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //gets selected recipe from the list as current_recipe
        arguments?.let {
            recipeEntity = arguments?.get("current_recipe") as RecipeEntity
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // binds variables to components of the view
        var recipeInstructions = view.findViewById<TextView>(R.id.recipe_instructions)
        var nutritionalInformationDetails = view.findViewById<LinearLayout>(R.id.nutritionalInformationDetails)
        var recipeGlutenfree = view.findViewById<CheckBox>(R.id.glutenFreeCb)
        var recipeVegan = view.findViewById<CheckBox>(R.id.veganCb)
        var recipeVegetarian = view.findViewById<CheckBox>(R.id.vegetarianCb)
        var recipeVeryhealthy = view.findViewById<CheckBox>(R.id.veryHealthyCb)
        var recipeDairyfree = view.findViewById<CheckBox>(R.id.dairyFreeCb)
        var recipeImage = view.findViewById<ImageView>(R.id.recipe_image)
        var recipeTitle = view.findViewById<TextView>(R.id.recipe_title)
        var recipeTime = view.findViewById<TextView>(R.id.recipe_time)


        // sets the values of each component
        recipeGlutenfree.isChecked = recipeEntity.glutenFree
        recipeVegan.isChecked = recipeEntity.vegan
        recipeVegetarian.isChecked = recipeEntity.vegetarian
        recipeVeryhealthy.isChecked = recipeEntity.veryHealthy
        recipeDairyfree.isChecked = recipeEntity.dairyFree
        recipeTitle.text = recipeEntity.title
        recipeTime.text = recipeEntity.readyInMinutes
        if (recipeEntity.instructions.length == 0) {
            recipeInstructions.text = "Instruction are not available currently"
        }else {
            recipeInstructions.text = recipeEntity.instructions
        }
        "Test  me".replace("\\s+".toRegex(), " ")

        Glide.with(view.getContext())
            .load(recipeEntity.image)
            .override(100, 200)
            .fitCenter() // scale to fit entire image within ImageView
            .into(recipeImage);

        // manages expansion of linear layouts
        var expandCollapseNutritionalInformation =
            view.findViewById<ImageButton>(R.id.ExpandCollapseNutritionalInformation)
        expandCollapseNutritionalInformation?.setOnClickListener() {
            if (nutritionalInformationDetails.visibility == View.VISIBLE) {
                nutritionalInformationDetails.visibility = View.GONE
                expandCollapseNutritionalInformation.setImageResource(R.drawable.ic_expand_more)
            } else {
                nutritionalInformationDetails.visibility = View.VISIBLE
                expandCollapseNutritionalInformation.setImageResource(R.drawable.ic_expand_less)
            }
        }
        var expandCollapseSteps = view.findViewById<ImageButton>(R.id.ExpandCollapseSteps)
        expandCollapseSteps?.setOnClickListener() {
            if (recipeInstructions.visibility == View.VISIBLE) {
                recipeInstructions.visibility = View.GONE
                expandCollapseSteps.setImageResource(R.drawable.ic_expand_more)
            } else {
                recipeInstructions.visibility = View.VISIBLE
                expandCollapseSteps.setImageResource(R.drawable.ic_expand_less)
            }
        }

    }
}