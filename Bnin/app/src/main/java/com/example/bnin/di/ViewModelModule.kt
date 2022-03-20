package com.example.bnin.di

import com.example.bnin.vm.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

    /*
    * Class Name  : viewModelModule
    * Description : Declares the singleton component of RecipeViewModel
    * */
val viewModelModule = module {
    viewModel { RecipeViewModel(get()) }
}