package com.ashish.edvorarides.viewmodles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.edvorarides.repository.EdvoraRepository
import com.ashish.mygithub.utils.RidesViewState
import com.ashish.mygithub.utils.UserViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: EdvoraRepository) : ViewModel() {

    private val _startingState = MutableStateFlow<UserViewState>(UserViewState.Empty)
    val startingState = _startingState.asStateFlow()

    private val _ridesState = MutableStateFlow<RidesViewState>(RidesViewState.Empty)
    val ridesState = _ridesState.asStateFlow()

    fun getUser() {
        viewModelScope.launch {
            repository.getUser()
                .catch { e ->
                    _startingState.value = UserViewState.Error(e)
                }
                .collect {
                    _startingState.value = UserViewState.Success(it)
                }
        }
    }

    fun getAllRides() {
        viewModelScope.launch {
            repository.getAllRides()
                .catch { it ->
                    _ridesState.value = RidesViewState.Error(it)
                }
                .collect {
                    _ridesState.value = RidesViewState.Success(it)
                }
        }
    }

    fun upcomingRides(): Int {
        return 0
    }

    fun pastRides(): Int {
        return 0
    }


}


