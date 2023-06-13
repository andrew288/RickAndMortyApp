package com.example.rickandmorty.uis.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.model.PersonajeModel
import com.example.rickandmorty.domain.GetAllPersonajesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonajeViewModel @Inject constructor(
    private val getPersonajesUseCase: GetAllPersonajesUseCase
): ViewModel() {
    private val _listPersonajeModel = MutableStateFlow<List<PersonajeModel>>(emptyList())
    val listPersonajeModel: StateFlow<List<PersonajeModel>> get() = _listPersonajeModel

    fun onCreate() {
        viewModelScope.launch {
            val result = getPersonajesUseCase()
            if(!result.isNullOrEmpty()){
                _listPersonajeModel.emit(result)
            }
        }
    }

    suspend fun getListPersonajeModel(): List<PersonajeModel>{
        return getPersonajesUseCase() ?: emptyList()
    }
}