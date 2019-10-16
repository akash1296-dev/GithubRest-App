package com.example.tapdemoapp.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tapdemoapp.R
import com.example.tapdemoapp.RetrofitFetch
import com.example.tapdemoapp.services.FetchAllNews
import kotlinx.android.synthetic.main.fragment_community.*
import retrofit2.Call
import retrofit2.Response
import com.example.tapdemoapp.model.ArticlesModel
import com.example.tapdemoapp.adapter.CommunityAdapter

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Community.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Community.newInstance] factory method to
 * create an instance of this fragment.
 */

class Community : Fragment() {

    private val TAG = "Community"
    val retrofit = RetrofitFetch().retrofit()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_community,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCommunity.layoutManager = LinearLayoutManager(context)
        val api = retrofit.create(FetchAllNews::class.java)
        api.fetchNews().enqueue(object : retrofit2.Callback<ArticlesModel> {
            override fun onFailure(call: Call<ArticlesModel>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ArticlesModel>, response: Response<ArticlesModel>) {
                Log.d(TAG,"${response.body()}")
                showAllNews(response.body()!!)
            }

        })

        /*val downloadData = NewsFetch()

        try{
            val url = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=ca0611520507499b8ea20883258ab93d"
             downloadData.execute(url)
        } catch (e: Exception) {
            e.printStackTrace()
        }*/
    }

    /*inner class NewsFetch : AsyncTask<String,Void,String>() {
        override fun doInBackground(vararg params: String?): String {
            var result = ""
            var url: URL
            val httpUrlConnection : HttpURLConnection

            try{
                url =URL(params[0])
                httpUrlConnection = url.openConnection() as HttpURLConnection
                val inputStream = httpUrlConnection.inputStream
                val inputStreamReader = InputStreamReader(inputStream)

                var data = inputStreamReader.read()
                while (data > 0) {
                    val char = data.toChar()
                    result += char

                    data = inputStreamReader.read()
                }
                    return result
            }catch (e: Exception){
                e.printStackTrace()
            }
            return result
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            try {
                val JSONObject = JSONObject(result)
                Log.d("source is :","$JSONObject")
                val base = JSONObject.getString("articles")
                Log.d("base is:","$base")
                val source = JSONObject.getJSONArray("articles")
                Log.d("source is ","$source")

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }*/  //commented statements

    private fun showAllNews(body: ArticlesModel) {
        Log.d(TAG,"$body")
        rvCommunity.adapter = CommunityAdapter(body)
    }

}
