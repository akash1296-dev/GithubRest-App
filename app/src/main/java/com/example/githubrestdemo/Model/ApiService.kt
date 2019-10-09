package com.example.githubrestdemo.Model

import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun fetchAllUsers(): retrofit2.Call<List<User>>
}