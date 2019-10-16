package com.example.tapdemoapp.services

import com.example.tapdemoapp.model.ArticlesModel
import com.example.tapdemoapp.model.News
import retrofit2.http.GET

interface FetchAllNews {
    @GET("top-headlines?sources=techcrunch&apiKey=ca0611520507499b8ea20883258ab93d")
    fun fetchNews(): retrofit2.Call<ArticlesModel>
}