package com.example.domain.data.repository

import com.example.domain.data.entity.ListElement

interface ListRepository {
    suspend fun getList(): List<ListElement>
    suspend fun getElementListById(id: Long): ListElement
}