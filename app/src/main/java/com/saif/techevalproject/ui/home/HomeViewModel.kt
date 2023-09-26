package com.saif.techevalproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saif.techevalproject.data.datasource.Repository
import com.saif.techevalproject.model.SeriesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _series = MutableStateFlow<SeriesResponse>(SeriesResponse(mutableListOf()))
    val series: StateFlow<SeriesResponse> = _series

    init {
        viewModelScope.launch {
            repository.getSeries("mario").collectLatest { response->
                response?.let {
                    _series.value = it
                }
            }
        }
    }
}