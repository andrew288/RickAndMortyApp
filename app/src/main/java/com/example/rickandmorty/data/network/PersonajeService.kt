package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.model.PersonajeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonajeService @Inject constructor(private val api:PersonajeApiClient) {

    suspend fun getPersonajes(): List<PersonajeModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllPersonajes()
            println("DATA DE RESULTS")
            println("DATA DE RESULTS" + response.body()?.results)
            response.body()?.results ?: emptyList()
        }
    }
}