package com.example.rickandmorty.uis.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import com.example.rickandmorty.uis.view.viewmodel.PersonajeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val personajeViewModel: PersonajeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personajeViewModel.onCreate()
        setContent {
            RickAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val personajeList by personajeViewModel.listPersonajeModel.collectAsState(initial = emptyList())
                    LazyColumn{
                        items(personajeList){
                                personaje ->
                            Text(text ="NAME: ${personaje.name}, ESPECIES: ${personaje.species}, GENDER: ${personaje.gender}")
                        }
                    }

                }
            }
        }
    }
}