package com.livinglifetechway.background_manager

import android.app.Activity
import android.app.Application
import android.os.Bundle


object BackgroundManager : Application.ActivityLifecycleCallbacks {

    private val TAG = BackgroundManager::class.java.simpleName

    private var counter = 0
    private var isBackground = true

    // listeners
    private var mListeners: MutableList<BackgroundStateChangeListener> = mutableListOf()

    private var init = false

    /**
     * Initializes BackgroundManager with the Application class
     * BackgroundManager must be initialized in the application class
     */
    fun init(context: Application) {
        if (!init) {
            context.registerActivityLifecycleCallbacks(this)
            init = true
        }
    }

    override fun onActivityStarted(p0: Activity?) {
        counter++

        if (counter > 0) {
            isBackground = false
            callListeners()
        }
    }

    override fun onActivityStopped(p0: Activity?) {
        counter--

        if (counter == 0) {
            isBackground = true
            callListeners()
        }
    }

    /**
     * Call listener methods
     */
    private fun callListeners(): Unit {
        if (isBackground)
            mListeners.forEach { it.isBackground() }
        else
            mListeners.forEach { it.isForeground() }
    }

    /**
     * Returns true if app is in background
     * Note: If not initialized it will always return true
     */
    fun isBackground() = isBackground

    /**
     * Returns true if app is in foreground
     * Note: If not initialized it will always return false
     */
    fun isForeground() = !isBackground

    /**
     * Interface for BackgroundStateChangeListener
     */
    interface BackgroundStateChangeListener {
        fun isBackground() {}
        fun isForeground() {}
    }

    /**
     * Adds a BackgroundStateChangeListener
     */
    fun addBackgroundStateChangeListener(listener: BackgroundStateChangeListener): BackgroundStateChangeListener {
        if (init) {
            mListeners.add(listener)
            return listener
        } else {
            throw IllegalStateException("Background Manager must be initialized in Application class")
        }
    }

    /**
     * Removes given BackgroundStateChangeListener
     */
    fun removeBackgroundStateChangeListener(listener: BackgroundStateChangeListener) {
        if (init) {
            mListeners.remove(listener)
        } else {
            throw IllegalStateException("Background Manager must be initialized in Application class")
        }
    }

    /**
     * Removes all BackgroundStateChangeListener
     */
    fun removeAllListeners() {
        mListeners.clear()
    }

    // Unused methods below
    override fun onActivityPaused(p0: Activity?) {}

    override fun onActivityResumed(p0: Activity?) {}

    override fun onActivityDestroyed(p0: Activity?) {}

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {}

    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {}
}

