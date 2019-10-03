package com.example.githubrestdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrestdemo.Adapter.UserAdapterDetails
import com.example.githubrestdemo.Model.ApiServiceDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserDetailsActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val result = intent.getStringExtra("login")

        val api2 = retrofit.create(ApiServiceDetails::class.java)

        recyclerView = findViewById(R.id.recyclerView2)


        api2.fetchAllUsers(result).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d(
                    "akash",
                    "OnResponse"
                )                                                         //onResponse${response.body()!![1].avatar_url}
                showDetailsOfUser(response.body()!!)

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
                Log.d("onFailure", "-----------")
            }

            /* override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                 Log.d("akash", "OnResponse")                                                         //onResponse${response.body()!![1].avatar_url}
                 showDetailsOfUser(response.body()!!)
             }

             override fun onFailure(call: Call<List<User>>, t: Throwable) {
                 t.printStackTrace()
                 Log.d("onFailure","-----------")
             }*/


        })


    }

    private fun showDetailsOfUser(users: User) {
        println(users)
        recyclerView?.apply {
            //println("[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]")
            layoutManager = LinearLayoutManager(this@UserDetailsActivity)
            //println("//////////////////////////////////////////////////////////")
            adapter = UserAdapterDetails(users)
        }
    }
}
