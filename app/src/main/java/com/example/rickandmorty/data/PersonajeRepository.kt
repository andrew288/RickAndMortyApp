package com.example.rickandmorty.data

import com.example.rickandmorty.data.model.PersonajeModel
import com.example.rickandmorty.data.network.PersonajeService
import javax.inject.Inject

class PersonajeRepository @Inject constructor(private val api: PersonajeService){
    suspend fun getAllPersonajesFromApi(): List<PersonajeModel> {
        return api.getPersonajes()
    }
}