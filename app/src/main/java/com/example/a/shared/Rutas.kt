package com.example.ejerciciosviewmodel.shared

sealed class Rutas(val ruta: String){
    object Temperatura : Rutas("temperatura")
    object Rave : Rutas("rave")
    object Menu : Rutas("menu")
    object Listas : Rutas("listas")
}
