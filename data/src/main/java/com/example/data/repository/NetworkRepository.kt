package com.example.data.repository

import android.content.res.Resources
import com.example.data.network.Api
import com.example.domain.data.entity.ListElement
import com.example.domain.data.repository.CacheRepository
import com.example.domain.data.repository.ListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkRepository(
    private val api: Api,
    private val cacheRepository: CacheRepository
) : ListRepository {
    override suspend fun getList(): List<ListElement> = withContext(Dispatchers.IO) {
        cacheRepository.getAndSave(
            force = true,
            key = "getList",
            remote = {
                api.getData().data.elements
            }
        )
    }

    override suspend fun getElementListById(id: Long): ListElement = withContext(Dispatchers.IO) {
        cacheRepository.getAndSave(
            force = true,
            key = "getList",
            remote = {
                api.getData().data.elements
            }
        ).find { it.id == id } ?: throw Resources.NotFoundException()
    }
}