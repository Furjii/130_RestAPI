package com.example.aplikasikontak.ui.kontak.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasikontak.model.Kontak
import com.example.aplikasikontak.repository.KontakRepository
import kotlinx.coroutines.launch

class InsertViewModel (private val kontakRepositori: KontakRepository) : ViewModel(){
        var insertKontakState by mutableStateOf(InsertUiState())
            private set

        fun updateInsertKontakState(insertUiEvent: InsertUiEvent){
            insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
        }

        suspend fun insertKontak(){
            viewModelScope.launch{
                try {
                    kontakRepositori.insertkontak(insertKontakState.insertUiEvent.toKontak())
                } catch (e: Exception){
                    e.printStackTrace()
                }

            }
        }

    }
    data class InsertUiState(
        val insertUiEvent: InsertUiEvent = InsertUiEvent()
    )

    data class InsertUiEvent(
        val id: Int = 0,
        val nama: String = "",
        val email: String = "",
        val nohp: String = ""
    )

    fun InsertUiEvent.toKontak(): Kontak = Kontak(
        id = id,
        nama = nama,
        alamat = email,
        telpon = nohp
    )

    fun Kontak.toUiStateKontak(): InsertUiState = InsertUiState(
        insertUiEvent = toInsertUiEvent()
    )

    fun Kontak.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
        id = id,
        nama = nama,
        email = alamat,
        nohp = telpon
    )
