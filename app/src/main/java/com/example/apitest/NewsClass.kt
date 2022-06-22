package com.example.apitest

data class NewsClass(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)