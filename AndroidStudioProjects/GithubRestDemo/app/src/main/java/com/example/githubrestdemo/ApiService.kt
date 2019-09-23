package com.example.githubrestdemo

import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun fetchAllUsers(): retrofit2.Call<List<User>>
}