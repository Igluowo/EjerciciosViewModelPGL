package com.example.ejerciciosviewmodel.shared

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlin.random.Random

class LMViewModel : ViewModel(){

    private val _listaValores = MutableStateFlow(mutableStateListOf<Int>())
    val listaValores = _listaValores.asStateFlow()

    init {

    }
    fun rellenarLista(){
        //
    }

}