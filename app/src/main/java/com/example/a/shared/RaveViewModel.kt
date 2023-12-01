package com.example.ejerciciosviewmodel.shared

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejerciciosdialogosylistas.utils.FuncionesUtiles
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class RaveViewModel : ViewModel() {
    private var _entradaUsuario = MutableStateFlow("")
    var entradaUsuario = _entradaUsuario.asStateFlow()

    private var _radioButtonSeleccionado = MutableStateFlow("")
    var radioButtonSeleccionado = _radioButtonSeleccionado.asStateFlow()

    private var _colorFondo = MutableStateFlow(Color.Red)
    var colorFondo = _colorFondo.asStateFlow()

    fun actualizarEntrada(entradaNueva : String) {
        _entradaUsuario.value = entradaNueva
    }

    fun actualizarRadioButton(cambioRealizado : String) {
        _radioButtonSeleccionado.value = cambioRealizado
    }

    fun empezarFiesta() {
        if (_radioButtonSeleccionado.value == "SUAVE") {
            viewModelScope.launch {
                while (true) {
                    _colorFondo.value = Color.Blue
                    delay(5000)
                    _colorFondo.value = Color.Magenta
                    delay(5000)
                }
            }
        }else if (_radioButtonSeleccionado.value == "MEDIO") {
            viewModelScope.launch {
                while (true) {
                    _colorFondo.value = Color.Blue
                    delay(2000)
                    _colorFondo.value = Color.Magenta
                    delay(2000)
                }
            }
        }else{
            viewModelScope.launch {
                while (true) {
                    _colorFondo.value = Color.Blue
                    delay(1000)
                    _colorFondo.value = Color.Magenta
                    delay(1000)
                }
            }
        }
    }
}