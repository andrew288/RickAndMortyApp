package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.model.ResponseData
import retrofit2.Response
import retrofit2.http.GET

interface PersonajeApiClient {
    @GET("character")
    suspend fun getAllPersonajes(): Response<ResponseData>
}