package com.example.aplikasikontak.repository

import com.example.aplikasikontak.model.Kontak
import com.example.aplikasikontak.service_api.KontakService

interface KontakRepository {
    /** Fetches List of Kontak from kontakApi */

    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /** Fetches List of Kontak from KontakApi*/

    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}