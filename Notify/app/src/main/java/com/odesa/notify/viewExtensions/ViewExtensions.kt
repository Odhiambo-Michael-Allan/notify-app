package com.odesa.notify.viewExtensions

import android.widget.EditText
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.odesa.notify.MainActivity
import timber.log.Timber

fun EditText.showSoftKeyboard( ) {
    if ( requestFocus() ) {
        Timber.d( "EDIT TEXT IS REQUESTING FOCUS" )
        WindowCompat.getInsetsController( ( context as MainActivity ).window, this )
            .show( WindowInsetsCompat.Type.ime() )
    }
}