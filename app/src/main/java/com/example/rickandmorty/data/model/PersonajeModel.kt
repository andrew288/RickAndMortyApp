package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class PersonajeModel(
    @SerializedName("name") val name: String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("image") val image: String,
)
