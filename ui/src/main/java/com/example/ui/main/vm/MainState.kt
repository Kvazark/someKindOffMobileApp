package com.example.ui.main.vm

import com.example.domain.entity.ListElementEntity

sealed class MainState {
    data class Content(
        val list: List<ListElementEntity>
    ) : MainState()

    data class Error(
        val message: String
    ) : MainState()

    object Loading : MainState()
}