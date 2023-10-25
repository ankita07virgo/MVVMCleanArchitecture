package com.example.democleanmvvm.presentation.spacecraftlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.democleanmvvm.common.Resource
import com.example.democleanmvvm.domain.use_cases.GetSpaceCraftListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SpaceCraftListViewModel @Inject constructor(private val getSpaceCraftListUseCase: GetSpaceCraftListUseCase) :
    ViewModel() {
        private val _list = mutableStateOf(SpaceCraftState())
    val list : State<SpaceCraftState> = _list

    init {
        getSpaceCraftList()
    }

    private fun getSpaceCraftList(){
        getSpaceCraftListUseCase().onEach {
            when(it) {
                is Resource.Loading-> {
                    _list.value = SpaceCraftState(isLoading = true)
                }
                is Resource.Success-> {
                    _list.value = SpaceCraftState(data = it.data)
                }

                is Resource.Error-> {
                    _list.value = SpaceCraftState(error = it.message.toString())
                }



            }
        }
    }
}