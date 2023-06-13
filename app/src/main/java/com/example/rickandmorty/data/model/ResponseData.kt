package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("results") val results: List<PersonajeModel>,
)
