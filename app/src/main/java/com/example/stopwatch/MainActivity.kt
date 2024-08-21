package com.example.stopwatch


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer


class MainActivity : AppCompatActivity() {

    private lateinit var chronometer: Chronometer
    private lateinit var startButton: Button
    private lateinit var pauseButton: Button
    private lateinit var resetButton: Button
    private var isChronometerRunning = false
    private var chronometerBase: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById(R.id.chronos)
        startButton = findViewById(R.id.startButton)
        pauseButton = findViewById(R.id.pauseButton)
        resetButton = findViewById(R.id.resetButton)

        startButton.setOnClickListener {
            if (!isChronometerRunning) {
                chronometer.base = SystemClock.elapsedRealtime() - chronometerBase
                chronometer.start()
                isChronometerRunning = true
            }
        }

        pauseButton.setOnClickListener {
            if (isChronometerRunning) {
                chronometer.stop()
                chronometerBase = SystemClock.elapsedRealtime() - chronometer.base
                isChronometerRunning = false
            }
        }

        resetButton.setOnClickListener {
            chronometer.stop()
            chronometer.base = SystemClock.elapsedRealtime()
            chronometerBase = 0L
            isChronometerRunning = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isChronometerRunning", isChronometerRunning)
        outState.putLong("chronometerBase", chronometerBase)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isChronometerRunning = savedInstanceState.getBoolean("isChronometerRunning")
        chronometerBase = savedInstanceState.getLong("chronometerBase")

        if (isChronometerRunning) {
            chronometer.base = SystemClock.elapsedRealtime() - chronometerBase
            chronometer.start()
        }
    }

    override fun onPause() {
        super.onPause()
        // Add code to handle the pause state of your app
    }

    override fun onStop() {
        super.onStop()
        // Add code to handle the stop state of your app
    }
}