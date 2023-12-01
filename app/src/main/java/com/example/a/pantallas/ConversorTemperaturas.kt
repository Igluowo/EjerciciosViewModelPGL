package com.example.ejerciciosviewmodel.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ejerciciosviewmodel.shared.TemperaturaViewModel


@Composable
fun ConversorTemperaturas(
    modifier: Modifier = Modifier,
    temperaturaViewModel: TemperaturaViewModel = viewModel()
){
    val redondeo = temperaturaViewModel.redondeo.collectAsState().value
    PantallaTemperaturas(
        redondeo = redondeo,
        onRedondeoChanged = { temperaturaViewModel.actualizarSwitch(it) },
        calcularTemperatura = { temperaturaViewModel.actualizarResultado(it) },
        temperatura = temperaturaViewModel.temperaturaUsuario.collectAsState().value,
        onValueChange = { temperaturaViewModel.actualizarTemperatura(it) },
        result = temperaturaViewModel.resultado.collectAsState().value
    )
}


@Composable
fun PantallaTemperaturas(
    modifier: Modifier = Modifier,
    redondeo:Boolean,
    onRedondeoChanged: (Boolean) -> Unit,
    calcularTemperatura:(String) -> Unit,
    temperatura: String,
    onValueChange: (String) -> Unit,
    result: String
){

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            "Cambia de C a F",
            fontSize = 24.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        //Spacer(modifier = modifier.height(16.dp))

        CuadroTexto(
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {focusManager.clearFocus()}
            ),
            value = temperatura,
            onValueChange = onValueChange,
            label = "Introduce la temperatura"
        )

        FilaRedondeo(
            roundUp = redondeo,
            onRoundUpChanged = onRedondeoChanged
        )

        //Spacer(Modifier.height(24.dp)


        Text(
            text = result,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Button(onClick = { calcularTemperatura(temperatura) }) {
            Text(text = "Cambiar temperatura")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CuadroTexto(
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    value: String,
    onValueChange: (String) -> Unit,
    label: String
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}


@Composable
fun FilaRedondeo(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp),
        verticalAlignment = Alignment.CenterVertically)
    {
        Text(text = "¿Quieres redondear?")
        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Yellow,
                checkedThumbColor = Color.Red)
        )
    }
}