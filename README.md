# Bnin

Bnin is an android application that gives users random recipes to help them decide what to cook :-)

## Overview

Bnin consumes the api : https://spoonacular.com/food-api : 
  - It uses the endpoint /random
  - Using the api required an API key that we got simply by registering to the website. The  API key is hard coded in the Routing configuration

Bnin displays a random list of recipes . By clicking on each recipe, the user can get the following details:
- The time needed to prepare the meal
- The instructions of the recipe 
- Nutritional information (vegetarian, vegan, dairy free, gluten free)
The health score of each recipe is displayed in the list. The score is a percentage provided by the food-api of spoonacular

## User stories
Two user stories are implemented in the app : 
- As a user, I want to get a list of recipes so that I decide what to cook
- As a user, I want to get details about the recipe so that I know its instructions and nutrional information

## Screens
![Alt text](recipe_home.PNG?raw=true "Home page")
![Alt text](recipe_list.PNG?raw=true "Rcipes list page")
![Alt text](recipe_details.PNG?raw=true "Rcipes Details page")


## Architecture
The architecture is based on the AAC (Android Architecture Components) that provides tools to manage :
- Data persistence 
- The application life cycle
- The interaction between UI components and Data

The project's structure contains six packages : 
- api : 
  - This package manages the call of the api spoonaciluar and the deserialization of the json response
  - The api is called using Fuel library
- db : 
  - This package defines the database schema using the ORM Room
- di :
  - This package defines the dependency injection graph using Koin library
- repository
  - This package defines the data access layer. A coroutine is used to fetch data in three steps :
  - Data is fetched from spoonacular api
  - Database is cleared from data 
  - The newly fetched data is inserted in database 
- ui
  - This package contains the main activity and the three fragments of the application
- vm
  - This package defines the RecipeViewModel that uses LiveData as a data holder

## References 
- Spoonacular documentation :  https://spoonacular.com/food-api/docs
- Fuel Tutorial : https://blog.ippon.fr/2018/11/30/android-architecture-components-mise-en-pratique-part-5-fuel/
- RecyclerView documentation : https://developer.android.com/guide/topics/ui/layout/recyclerview
- Room documentatioon : https://developer.android.com/training/data-storage/room

