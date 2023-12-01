package com.example.ejerciciosviewmodel.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ejerciciosviewmodel.shared.RaveViewModel

@Composable
fun RaveInTheRiver(){

    val focusManager = LocalFocusManager.current
    val viewModelRaven: RaveViewModel = viewModel()

    Column(Modifier.background(viewModelRaven.colorFondo.collectAsState().value)){
        CuadroTexto(value = viewModelRaven.entradaUsuario.collectAsState().value,
            onValueChange = { viewModelRaven.actualizarEntrada(it) },
            label = "Introduce un número de segundos",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {focusManager.clearFocus()}
            ))
        Text("", fontSize = 25.sp)
        RadioGroup(viewModelRaven.radioButtonSeleccionado.collectAsState().value, {viewModelRaven.actualizarRadioButton(it)})
        Column(modifier = Modifier.fillMaxSize()
            , verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
         Button(onClick = { viewModelRaven.empezarFiesta() },
         enabled = true) {
             Text("Empezar!")
         }
        }
    }
}

@Composable
fun RadioGroup(seleccionado : String, funcion: (String) -> Unit) {
    val opciones = arrayListOf("SUAVE", "MEDIO", " A TOPE")
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxWidth()){
        opciones.forEach {
            RadioButton(selected = seleccionado == it, onClick = { funcion(it) })
            Text(it)
        }
    }

}


