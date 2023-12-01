package com.example.ejerciciosviewmodel.pantallas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ejerciciosviewmodel.shared.LMViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch

@Composable
fun VisualizadorLista(){
    val viewModelListas : LMViewModel = viewModel()
    Column(){
        Text(text = "Todos los valores: ", fontSize = 30.sp)
        LazyRow(){

        }

        Text(text = "Aquellos mayores que 10  ", fontSize = 30.sp)
        LazyRow(){

        }

        Text(text = "Aquellos menores que 10", fontSize = 30.sp)
        LazyRow(){

        }

        Row(horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {}){
                Text("Recargar lista")
            }

            Button(onClick = {}){
                Text("Añadir elemento")
            }
        }

    }
    }


@Composable
fun CardNumero(valor: Int){
   Card(modifier = Modifier.size(200.dp)) {
       Text(text = valor.toString(),
           fontSize = 50.sp,
           textAlign = TextAlign.Center,
           color = Color.Blue,
           modifier = Modifier.wrapContentSize(Alignment.Center))
   } 
}