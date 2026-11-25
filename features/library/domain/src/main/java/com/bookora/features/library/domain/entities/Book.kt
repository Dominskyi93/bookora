package com.bookora.features.library.domain.entities

data class Book(
    val key: String,
    val title: String,
    val authorName: List<String>,
    val firstPublishYear: Int,
    val coverI: Int
)