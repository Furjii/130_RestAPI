package com.example.aplikasikontak.ui

import android.app.Application
import com.example.aplikasikontak.repository.AppContainer
import com.example.aplikasikontak.repository.KontakContainer

class KontakAplikation : Application() {
    /** AppContainer instance used by the rest of classes to obtain depencies */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}