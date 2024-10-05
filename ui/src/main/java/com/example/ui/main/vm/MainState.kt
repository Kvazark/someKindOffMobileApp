package com.example.ui.main.vm

import com.example.domain.entity.ListElement

sealed class MainState {
    data class Content(
        val list: List<ListElement>
    ) : MainState()

    data class Error(
        val message: String
    ) : MainState()

    object Loading : MainState()
}