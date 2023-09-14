package com.lave.tasksciflare.api

import com.lave.tasksciflare.model.User
import com.lave.tasksciflare.model.UserItem
import com.lave.tasksciflare.model.UserModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface RetrofitAPI {

    @GET("venkatesan")
     fun getData() : Call<ArrayList<UserItem>>

    @Headers("Content-Type: application/json")
    @POST("venkatesan")
    fun postUserData(@Body body: JSONObject): Call<Unit>


}