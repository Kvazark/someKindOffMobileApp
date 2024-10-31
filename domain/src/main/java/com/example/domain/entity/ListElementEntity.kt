package com.example.domain.entity

import com.example.domain.data.entity.ListButton

data class ListElementEntity(
    val id: Long,
    val title: String,
    val date: String,
    val country: String,
    val image:String,
    val button: ListButton?,
    val like: Boolean
)