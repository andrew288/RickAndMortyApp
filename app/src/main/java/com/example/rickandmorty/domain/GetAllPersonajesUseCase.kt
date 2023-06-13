package com.example.rickandmorty.domain

import com.example.rickandmorty.data.PersonajeRepository
import com.example.rickandmorty.data.model.PersonajeModel
import javax.inject.Inject

class GetAllPersonajesUseCase @Inject constructor(private val repository: PersonajeRepository) {
    suspend operator fun invoke(): List<PersonajeModel> {
        return repository.getAllPersonajesFromApi()
    }
}