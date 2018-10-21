package com.livinglifetechway.applicationbackgroundmanager

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.livinglifetechway.background_manager.BackgroundManager
import com.livinglifetechway.k4kotlin.toastNow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // using isBackground() method
        Handler().postDelayed({
            toastNow("Currently in background? " + BackgroundManager.isBackground())
        }, 2000)

        // using isForeground method
        Handler().postDelayed({
            toastNow("Currently in foreground? " + BackgroundManager.isForeground())
        }, 4000)
    }
}
