package com.example.githubrestdemo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubrestdemo.Fragments.EmojiFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.githubrestdemo.Fragments.login as login
class MainActivity : AppCompatActivity() {

    //private var recyclerView: RecyclerView? = null

    /*private val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create()).build()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragmentLogin(login())

        //recyclerView = findViewById(R.id.recyclerView)

        /*val api = retrofit.create(ApiService::class.java)
        api.fetchAllUsers().enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
                //d("aakash","onResponse ${response.body()!![0].url}")
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("aakash", "onFailure")
            }
        })
*/
        // ----------------------------------------------------------------
        //-------------------------------------------------------------------
        /*val users = mutableListOf<User>()
        for(i in 0..100) {
            users.add(User("Aakash", "Yadav","akash1296@gmail.com","https://abc.com"))
        }*/
        btnEmojis.setOnClickListener {
            loadFragment(EmojiFragment())
        }
    }

    private fun loadFragmentLogin(loginFrag : login) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.rootLinear,loginFrag)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun loadFragment(emojiFragment: EmojiFragment) {
        val ft = supportFragmentManager.beginTransaction()
        //ft.replace(R.id.root, emojiFragment)
        ft.replace(R.id.rootLinear, emojiFragment)
        //frameLogin.visibility = View.GONE
        ft.addToBackStack(null)
        //recyclerView?.visibility = View.GONE
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

    /*private fun showData(users: List<User>) {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(users)
        }

    }*/

    companion object {
        const val TAG = "MainActivity"
    }
}
