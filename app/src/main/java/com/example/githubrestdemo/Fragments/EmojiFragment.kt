package com.example.githubrestdemo.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrestdemo.Adapter.EmojiAdapter
import com.example.githubrestdemo.Model.ApiEmoji
import com.example.githubrestdemo.Model.Emoji
import com.example.githubrestdemo.R
import kotlinx.android.synthetic.main.fragment_emoji.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log


class EmojiFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    val TAG = "EmojiFragment"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emoji, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val api3 = retrofit().create(ApiEmoji::class.java)

        api3.fetchAllEmojis().enqueue(object : Callback<HashMap<String, String>> {

            override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<HashMap<String, String>>, response: Response<HashMap<String, String>>) {
                val hashMap = response.body()
                val totalItems = hashMap?.size ?: 0
                Log.d(TAG, "totalItems $totalItems")

                /*val key = hashMap?.filterValues {
                    it == "+1"
                }?.keys*/

                val values = ArrayList(hashMap!!.values)
                Log.d("haspmap value is:", "$values")

                val totalSize = values?.size
                Log.d(TAG,"value size is $totalSize")


                showEmoji(values)

                /*hashMap?.keys?.forEach { key ->
                    Log.d(TAG, "$key => ${hashMap[key]}")
                }*/
            }

        })
    }

    private fun retrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)  // <-- this is the important line!
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        return retrofit
    }

    private fun showEmoji(body: ArrayList<String>) {
        rvEmojis.layoutManager = LinearLayoutManager(context)
        rvEmojis.adapter = EmojiAdapter(body)



        /*recyclerView?.apply {
            Log.d("frag:RespbodyisRec: ", "$body")
            layoutManager = LinearLayoutManager(context)
            adapter = EmojiAdapter(body)
        }*/
    }
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }*/

}
