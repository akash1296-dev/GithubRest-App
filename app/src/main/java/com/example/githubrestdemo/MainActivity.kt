package com.example.githubrestdemo

//import kotlinx.android.synthetic.main.avtivity_user_row.*
//import kotlinx.android.synthetic.main.user_row.*
import android.os.Bundle
import android.util.Log.d
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrestdemo.Adapter.UserAdapter
import com.example.githubrestdemo.Fragments.EmojiFragment
import com.example.githubrestdemo.Model.ApiService
import com.example.githubrestdemo.Model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null


    private val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val api = retrofit.create(ApiService::class.java)
        api.fetchAllUsers().enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
                //d("aakash","onResponse ${response.body()!![0].url}")
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("aakash", "onFailure")
            }


        })

        // ----------------------------------------------------------------
        //-------------------------------------------------------------------
        /*val users = mutableListOf<User>()
        for(i in 0..100) {
            users.add(User("Aakash", "Yadav","akash1296@gmail.com","https://abc.com"))
        }*/
        btnEvents.setOnClickListener {
            loadFragment(EmojiFragment())
        }

    }

    private fun loadFragment(emojiFragment: EmojiFragment) {
        val ft = supportFragmentManager.beginTransaction()
        //ft.replace(R.id.root, emojiFragment)
        ft.replace(R.id.root, emojiFragment)
        ft.addToBackStack(null)
        recyclerView?.visibility = View.GONE
        ft.commit()

    }

    /*fun showDetails( v : View1) {
        val mytext: String = loginName.text as String
        println(mytext)
        val it = Intent(this, UserDetailsActivity::class.java)
        it.putExtra("login",mytext)
        startActivity(it)
        Log.d(Companion.TAG, "onClickHandler")

    }*/

    private fun showData(users: List<User>) {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(users)
        }

    }

    companion object {
        const val TAG = "MainActivity"
    }
}
