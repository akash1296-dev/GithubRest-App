package com.example.tapdemoapp

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFetch {

    val logging = HttpLoggingInterceptor()


    fun retrofit(): Retrofit {
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)  /* <-- this is the important line! */

        val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        Log.d("retrofit","$retrofit")
        return retrofit
    }
}
