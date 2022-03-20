package com.example.bnin.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bnin.R
import com.example.bnin.db.RecipeEntity
import com.example.bnin.vm.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bnin.repository.Resource
import com.example.bnin.repository.Status
import kotlinx.android.synthetic.main.fragment_recipes_list.*

    /*
    * Class Name  : RecipesListFragment
    * Description : The fragment that displays the list of recipes
    * */

class RecipesListFragment : Fragment(), RecipeAdapter.OnRecipeNameListener {
    private val recipeViewModel: RecipeViewModel by viewModel()
    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter(recipeEntities, this)
    }
    private val recipeEntities: MutableList<RecipeEntity> = mutableListOf()


    private val updateRecipes = Observer<Resource<Array<RecipeEntity>>> {

        // refreshes recipes array
        refreshRecipesList(it.data ?: emptyArray())

        // manages the swiping refresh layout
        when (it.status) {
            Status.SUCCESS -> {
                this@RecipesListFragment.swipe_refresh.isRefreshing = false
            }
            Status.ERROR -> {

                this@RecipesListFragment.swipe_refresh.isRefreshing = false
            }
            Status.LOADING -> this@RecipesListFragment.swipe_refresh.isRefreshing = true
        }
    }
    private fun refreshRecipesList(newRecipeEntities: Array<RecipeEntity>) {

        //refreshes recipes array
        recipeEntities.clear()
        recipeEntities.addAll(newRecipeEntities)
        recipeAdapter.notifyDataSetChanged()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_recipes_list, container, false)

        //initialize recycler view
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this.context)
        recyclerview.adapter = recipeAdapter

        this.recipeViewModel.recipes.observe(this@RecipesListFragment.viewLifecycleOwner,updateRecipes)
        return view
    }

    override fun onResume() {
        super.onResume()
        //fetches data into viewmodel
        this.recipeViewModel.fetchRecipes()
        this.swipe_refresh.setOnRefreshListener {
            this.recipeViewModel.fetchRecipes()
        }
    }

    override fun onPause() {
        this.swipe_refresh.setOnRefreshListener(null)
        super.onPause()
    }
    override fun onRecipeNameClicked(recipeEntity: RecipeEntity) {
        val bundle = bundleOf("current_recipe" to recipeEntity)

        //clicking on recipe name or image takes users to the details fragment
        findNavController().navigate(R.id.action_recipesList_to_recipeDetails, bundle)
    }


}
