package com.example.bnin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.bnin.R


    /*
    * Class Name  : HomeFragment
    * Description : First Fragment displayed to the user
    * */
class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        var recipesButton = view.findViewById<Button>(R.id.recipes_button)

        // Clicking on the button takes the user to the recipesListFragment
        recipesButton?.setOnClickListener()
        {

            view.findNavController().navigate(R.id.action_homeFragment_to_recipesList)
        }

        return view
    }


}