package com.example.tapdemoapp.model

data class News(val source: Source,
                val author: String,
                val title: String,
                val urlToImage: String,
                val description: String
                )