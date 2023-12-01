package com.example.ejerciciosviewmodel.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejerciciosviewmodel.pantallas.ConversorTemperaturas
import com.example.ejerciciosviewmodel.pantallas.PantallaMenu
import com.example.ejerciciosviewmodel.pantallas.RaveInTheRiver
import com.example.ejerciciosviewmodel.pantallas.VisualizadorLista
import com.example.ejerciciosviewmodel.shared.Rutas

@Composable
fun GrafoNavegacion(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.Menu.ruta){

        composable(Rutas.Menu.ruta){
            PantallaMenu(navController = navController)
        }

        composable(Rutas.Temperatura.ruta){
            ConversorTemperaturas()
        }

        composable(Rutas.Rave.ruta){
            RaveInTheRiver()
        }

        composable(Rutas.Listas.ruta){
            VisualizadorLista()
        }


    }

}