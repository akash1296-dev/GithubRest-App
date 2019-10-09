package com.example.githubrestdemo.Model

import retrofit2.http.GET

interface ApiEmoji {
    @GET("/emojis")
    fun fetchAllEmojis(): retrofit2.Call<HashMap<String, String>>
}