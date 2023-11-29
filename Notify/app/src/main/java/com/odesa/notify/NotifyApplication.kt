package com.odesa.notify

import android.app.Application
import timber.log.Timber

class NotifyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if ( BuildConfig.DEBUG ) Timber.plant( Timber.DebugTree() )
    }
}