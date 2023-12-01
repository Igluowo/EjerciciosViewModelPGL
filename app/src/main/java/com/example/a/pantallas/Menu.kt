package com.example.ejerciciosviewmodel.pantallas

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ejerciciosviewmodel.shared.Rutas

@Composable
fun PantallaMenu(navController: NavController){
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        BotonMenu(texto = "Ejercicio 1"){ navController.navigate(Rutas.Temperatura.ruta)}
        BotonMenu(texto = "Ejercicio 2"){ navController.navigate(Rutas.Rave.ruta)}
        BotonMenu(texto = "Ejercicio 3"){ navController.navigate(Rutas.Listas.ruta)}
    }
}

@Composable
fun BotonMenu(texto: String, funcion : () -> Unit) {
    Button(onClick = funcion){
        Text(texto)
    }
}