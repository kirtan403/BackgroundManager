# BackgroundManager
A lightweight background manager for Android to know whether your app is in the background or foreground

When at least one of your app's activity is in the foreground, your app is assumed to be in the foreground. And when none of your activities are in the foreground, your app is assumed to be in the background. BackgroundManager keeps track of no of activities in the foreground, and decides if an app is in the foreground or background.

Inspired from Doug's commit [here](https://github.com/CodingDoug/white-label-event-app/commit/3adbbb62e2c94feb14fb709af02da1b4742915c1?diff=unified) and from my own similiar approach [here](https://livinglifetechway.com/keep-your-firebase-realtime-database-connections-to-minimum/).  

## What can you do with this?

* Check if your app is in the background or in the foreground
* Add listeners which will be called whenever your app switches between background and foreground

## How can I do this?

First add dependency:

In project level gradle file:

    allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }  // Add this line
        }
    }
    
In your app build.gradle file: 

    dependencies {
        compile 'com.github.kirtan403:BackgroundManager:1.0.2'
    }
    
Now, initialize `BackgroundManager` in your Application class in `onCreate`:

        BackgroundManager.init(this)   // Initialize

Done! Now you are good to go.

## How can I check if my app is in the background or foreground?

There are 2 ways of doing this.

1. With `isBackground()` or `isForeground()` methods

Simply call `BackgroundManager.isBackground()` to know if app is in the backgorund or not.
Similarly `BackgroundManager.isForeground()` to know if app is in the foreground or not.

2. With listeners

You can attach listners and get call back whenerver your app transits between background and foreground.

To attach a listener you can call `BackgroundManager.addBackgroundStateChangeListener(mListener)`

And your listener will have `isBackground()` and `isForeground()` methods. Which will be called based on the new state of the app.

That's it, folks!

#BuildBetterApps
