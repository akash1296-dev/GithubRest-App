package com.example.githubrestdemo

data class User(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val url: String,
    val type: String
)