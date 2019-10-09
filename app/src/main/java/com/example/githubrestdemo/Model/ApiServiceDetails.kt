package com.example.githubrestdemo.Model

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceDetails {
    @GET("/users/{login}")
    fun fetchAllUsers(@Path("login") login: String): retrofit2.Call<User>
}