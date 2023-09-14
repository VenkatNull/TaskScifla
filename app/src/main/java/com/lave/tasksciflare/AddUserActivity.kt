package com.lave.tasksciflare

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lave.tasksciflare.api.RetrofitAPI
import com.lave.tasksciflare.api.RetrofitHelper
import com.lave.tasksciflare.model.UserModel
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class AddUserActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)



        val buttonSave=findViewById<Button>(R.id.btn_save_data)






        buttonSave.setOnClickListener {

            val Name:String=findViewById<EditText>(R.id.edt_name).text.toString()
            val Email:String=findViewById<EditText>(R.id.edt_email).text.toString()
            val MobileNumber:String=findViewById<EditText>(R.id.edt_mobile_number).text.toString()
            val Gender:String=findViewById<EditText>(R.id.edt_gender).text.toString()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/129949c229ee4f0db1f8b296b88cab3c/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            //val apiInterface: RetrofitAPI = retrofit.create(RetrofitAPI::class.java)
            val apiService = RetrofitHelper.getInstance().create(RetrofitAPI::class.java)
            val paramObject = JSONObject()
            try {

                paramObject.put("Name",Name)
                paramObject.put("Email",Email)
                paramObject.put("Mobile",MobileNumber)
                paramObject.put("Gender",Gender)

            }catch (e: JSONException) {
                e.printStackTrace();
            }
           /* val userCall: Call<UserModel> = apiService.postUserData(paramObject.toString())
            userCall.enqueue(this@AddUserActivity)*/

            apiService.postUserData(paramObject).enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    // handle the response
                    Log.v("TaskAdd",response.toString())

                    Toast.makeText(this@AddUserActivity,"User Added Successfully",Toast.LENGTH_SHORT).show()
                    val intent= Intent(this@AddUserActivity,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(call: Call<Unit >, t: Throwable) {
                    // handle the failure
                    Log.v("TaskFailure",t.toString())
                }
            })

        }



    }

}