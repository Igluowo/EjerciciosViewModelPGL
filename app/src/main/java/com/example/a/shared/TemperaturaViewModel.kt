package com.example.ejerciciosviewmodel.shared

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TemperaturaViewModel : ViewModel(){

    // Esta variable privada no es accesible desde fuera, y representa
    // el flow de nuestra variable de estado.
    private val _redondeo = MutableStateFlow(false)

    // Esta variable publica recoge y actualiza el valor del estado mutable, y es el que usará
    // la interfaz.
    val redondeo = _redondeo.asStateFlow()
    private var _temperaturaUsuario = MutableStateFlow("")
    var temperaturaUsuario = _temperaturaUsuario.asStateFlow()
    private var _resultado = MutableStateFlow("")
    var resultado = _resultado.asStateFlow()

    fun actualizarSwitch(nuevoValor : Boolean){
       _redondeo.value = nuevoValor
    }

    fun actualizarTemperatura(temperaturaUsuarioNueva: String) {
        _temperaturaUsuario.value = temperaturaUsuarioNueva
    }

    fun actualizarResultado(temperaturaResultado: String) {
        var conversion = temperaturaResultado.toFloat() * (9f / 5f) + 32
        if (_redondeo.value) {
            conversion = Math.round(conversion).toFloat()
        }
        _resultado.value = conversion.toString()
    }

}