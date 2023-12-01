package com.example.ejerciciosdialogosylistas.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object FuncionesUtiles {

    /*
     * Funcion que devuelve un Color generado al azar.
     */
    fun ColorRandom(): Color {
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)
        return Color(r, g, b)
    }
}