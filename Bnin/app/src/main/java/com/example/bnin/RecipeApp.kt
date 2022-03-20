package com.example.bnin
import android.app.Application
import com.example.bnin.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

    /*
    * Class Name  : RecipeApp
    * Description : This class is used to set up the dependency injection
    * */

class RecipeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setUpDependencyInjection()
    }

    private fun setUpDependencyInjection() {
        startKoin {
            androidContext(this@RecipeApp)
            modules(
                listOf(
                    daoModule,
                    databaseModule,
                    deserializerModule,
                    jsonModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }

}