package com.livinglifetechway.applicationbackgroundmanager

import android.app.Application
import android.util.Log
import com.livinglifetechway.background_manager.BackgroundManager

class MyApplication : Application() {

    private val TAG = MyApplication::class.java.simpleName

    override fun onCreate() {
        super.onCreate()

        BackgroundManager.init(this)

        // setup some listeners
        BackgroundManager.addBackgroundStateChangeListener(object : BackgroundManager.BackgroundStateChangeListener {
            override fun isBackground() {
                Log.d(TAG, "isBackground: from listener 1")
            }
        })

        BackgroundManager.addBackgroundStateChangeListener(object : BackgroundManager.BackgroundStateChangeListener {
            override fun isBackground() {
                Log.d(TAG, "isBackground: from listener 2")
            }

            override fun isForeground() {
                Log.d(TAG, "isForeground: from listener 2")
            }
        })
    }
}