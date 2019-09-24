package com.example.githubrestdemo

import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface ApiServiceDetails {
    @GET("/users/{login}")
    fun fetchAllUsers(@Path("login") login: String): retrofit2.Call<User>
}