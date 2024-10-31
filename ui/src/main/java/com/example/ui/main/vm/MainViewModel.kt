package com.example.ui.main.vm

import androidx.lifecycle.SavedStateHandle
import com.example.domain.usecase.ListUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.domain.data.repository.LocalStorageRepository
import com.example.domain.entity.ListElementEntity
import com.example.ui.main.MainScreenRoute
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    private val useCase: ListUseCase,
    private val localStorageRepository: LocalStorageRepository,
    private val handle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow<MainState>(MainState.Loading)
    val state: StateFlow<MainState>
        get() = _state

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            _state.emit(MainState.Error(throwable.message ?: "Ошибка"))
        }
    }

    init {
        viewModelScope.launch(context = exceptionHandler) {
            val result = useCase.execute(Unit)
            _state.emit(MainState.Content(result))
        }
        Timber.e(handle.toRoute<MainScreenRoute>().toString())
    }

    fun like(elementEntity: ListElementEntity, like: Boolean){
        localStorageRepository.like(elementEntity.id,like)
    }
}