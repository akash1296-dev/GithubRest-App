package com.example.githubrestdemo.Model

import com.example.githubrestdemo.User
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun fetchAllUsers(): retrofit2.Call<List<User>>
}