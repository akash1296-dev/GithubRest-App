package com.example.githubrestdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.view.View as View1

class MainActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val api = retrofit.create(ApiService::class.java)
        api.fetchAllUsers().enqueue(object : Callback<List<User>>{

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
                //d("aakash","onResponse ${response.body()!![0].url}")
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("aakash","onFailure")
            }

        })

        // ----------------------------------------------------------------

        



        //-------------------------------------------------------------------
        /*val users = mutableListOf<User>()
        for(i in 0..100) {
            users.add(User("Aakash", "Yadav","akash1296@gmail.com","https://abc.com"))
        }*/


    }

    fun showDetails( v : View1) {
        //val it = Intent(this, UserAdapterDetails::class.java)

        val api2 = retrofit.create(ApiServiceDetails::class.java)
       api2.fetchAllUsers().enqueue(object : Callback<List<User>> {

           override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                //d("akash","onResponse${response.body()!![1].avatar_url}")
                showDetailsOfUser(response.body()!!)
           }

           override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
           }


       })
        //startActivity(it)
        Log.d(Companion.TAG, "onClickHandler")

    }


    private fun showDetailsOfUser(users: List<User>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapterDetails(users)
        }
    }

    private fun showData(users: List<User>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(users)
        }

    }

    companion object {
        const val TAG = "MainActivity"
    }
}
