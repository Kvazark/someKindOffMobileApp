package com.example.domain.data.entity

data class ListElement(
    val id: Long,
    val image: String,
    val title: String,
    val date: String,
    val country: String,
    val button: ListButton?
)