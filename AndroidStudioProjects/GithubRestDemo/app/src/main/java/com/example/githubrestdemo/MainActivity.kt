package com.example.githubrestdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(ApiService::class.java)
        api.fetchAllUsers().enqueue(object : Callback<List<User>>{

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
                //d("aakash","onResponse ${response.body()!![0].url}")
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("aakash","onFailure")
            }

            // ----------------------------------------------------------------


            //-------------------------------------------------------------------



        })
        /*val users = mutableListOf<User>()
        for(i in 0..100) {
            users.add(User("Aakash", "Yadav","akash1296@gmail.com","https://abc.com"))
        }*/


    }

    private fun showData(users: List<User>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(users)
        }

    }
}
