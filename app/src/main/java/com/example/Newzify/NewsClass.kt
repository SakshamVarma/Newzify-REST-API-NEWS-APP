package com.example.Newzify

data class NewsClass(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)