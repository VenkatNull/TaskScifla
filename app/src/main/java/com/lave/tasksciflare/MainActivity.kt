package com.lave.tasksciflare

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lave.tasksciflare.adapter.UserAdapater
import com.lave.tasksciflare.api.RetrofitAPI
import com.lave.tasksciflare.api.RetrofitHelper
import com.lave.tasksciflare.model.User
import com.lave.tasksciflare.model.UserItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var rvMain : RecyclerView
    lateinit var userAdapter: UserAdapater
    lateinit var buttonAdd: ImageButton
    lateinit var buttonLocation: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvUser)

        rvMain.layoutManager = LinearLayoutManager(this)
        buttonAdd=findViewById(R.id.btn_add_new)
        buttonLocation=findViewById(R.id.btn_locat)

        buttonLocation.setOnClickListener {
            val intent=Intent(this,LocationActivity::class.java)
            startActivity(intent)
        }

        buttonAdd.setOnClickListener {
            val intent=Intent(this,AddUserActivity::class.java)
            startActivity(intent)
            finish()
        }

        getUserData()
        /*val quotesApi = RetrofitHelper.getInstance().create(RetrofitAPI::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getData()
            if (result != null)
            // Checking the results
                Log.d("ayush: ", result.body().toString())
        }*/


    }

    private fun getUserData() {


        val userApi = RetrofitHelper.getInstance().create(RetrofitAPI::class.java)

        var items = ArrayList<UserItem>()

        userApi.getData().enqueue(object : Callback<ArrayList<UserItem>> {
            override fun onResponse(
                call: Call<ArrayList<UserItem>>,
                response: Response<ArrayList<UserItem>>
            ) {
                items = response.body()!!

                userAdapter = UserAdapater(this@MainActivity,items )

                rvMain.adapter = userAdapter

                Log.d("data",items.toString())
            }

            override fun onFailure(call: Call<ArrayList<UserItem>>, t: Throwable) {
                Log.v("Error",t.toString())
            }

        })


    }
}