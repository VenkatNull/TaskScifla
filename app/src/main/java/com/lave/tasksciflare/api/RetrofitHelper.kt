package com.lave.tasksciflare.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitHelper {

    val baseUrl = "https://crudcrud.com/api/129949c229ee4f0db1f8b296b88cab3c/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
    val api by lazy {
        getInstance().create(RetrofitAPI::class.java)
    }

}