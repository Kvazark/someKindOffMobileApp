package com.example.ui.details.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.domain.data.repository.LocalStorageRepository
import com.example.domain.entity.ListElementEntity
import com.example.domain.usecase.ElementByIdUseCase
import com.example.ui.details.DetailsScreenRoute
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlinx.coroutines.delay

class DetailsViewModel(
    private val useCase: ElementByIdUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val storage: LocalStorageRepository
) : ViewModel() {
    private val _state = MutableStateFlow<DetailsState>(DetailsState.Loading)
    val state: StateFlow<DetailsState>
        get() = _state

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            val title = when (val curState = _state.value) {
                is DetailsState.Content -> curState.title
                is DetailsState.Error -> curState.title
                is DetailsState.Loading -> "Loading"
            }
            _state.emit(DetailsState.Error(title, throwable.message ?: "Error"))
        }
    }

    init {
        Timber.e(savedStateHandle.toRoute<DetailsScreenRoute>().toString())
        loadContent()
    }

    fun markAsRead() {
        val route = savedStateHandle.toRoute<DetailsScreenRoute>()
        storage.markAsRead(route.id)
    }

    private fun loadContent() {
        viewModelScope.launch(context = exceptionHandler) {
            val route = savedStateHandle.toRoute<DetailsScreenRoute>()
            val result = useCase.execute(route.id)
            _state.emit(DetailsState.Content(result, storage.isMarkAsRead(route.id)))
        }
    }

    fun like(elementEntity: ListElementEntity, like: Boolean) {
        storage.like(elementEntity.id, like)
        loadContent()
    }

}