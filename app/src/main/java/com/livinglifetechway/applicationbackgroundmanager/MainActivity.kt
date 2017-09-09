package com.livinglifetechway.applicationbackgroundmanager

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.livinglifetechway.background_manager.BackgroundManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // using isBackground() method
        Handler().postDelayed(Runnable {
            Toast.makeText(this@MainActivity, "Currently in background? " + BackgroundManager.isBackground(), Toast.LENGTH_SHORT).show()
        }, 2000)

        // using isForeground method
        Handler().postDelayed(Runnable {
            Toast.makeText(this@MainActivity, "Currently in foreground? " + BackgroundManager.isForeground(), Toast.LENGTH_SHORT).show()
        }, 4000)
    }
}
