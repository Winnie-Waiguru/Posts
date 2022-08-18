package dev.waiguru.mycreationapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Create an API client using retrofit
object APIClient {
    var retrofit= Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


//    Returns an api interface
    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return  retrofit.create(apiInterface)
    }

    }