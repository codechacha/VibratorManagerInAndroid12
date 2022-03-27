package com.example.vibration

import android.content.Context
import android.os.*
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


@RequiresApi(Build.VERSION_CODES.S)
class MainActivity : AppCompatActivity() {

    private val vibratorManager: VibratorManager by lazy {
        getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val vibrationEffect = VibrationEffect.createOneShot(
                500L,
                VibrationEffect.DEFAULT_AMPLITUDE
            )
            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
            vibratorManager.vibrate(combinedVibration)
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val timing = longArrayOf(100, 200, 100, 200, 100, 200)
            val vibrationEffect = VibrationEffect.createWaveform(timing, -1)
            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
            vibratorManager.vibrate(combinedVibration)
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            val timing = longArrayOf(100, 200, 100, 200, 100, 200)
            val amplitudes = intArrayOf(0, 50, 0, 100, 0, 200)
            val vibrationEffect = VibrationEffect.createWaveform(timing, amplitudes, -1)
            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
            vibratorManager.vibrate(combinedVibration)
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            val timing = longArrayOf(100, 200, 100, 200, 100, 200)
            val amplitudes = intArrayOf(0, 50, 0, 100, 0, 200)
            val vibrationEffect = VibrationEffect.createWaveform(timing, amplitudes, 0)
            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
            vibratorManager.vibrate(combinedVibration)
        }

        findViewById<Button>(R.id.button5).setOnClickListener {
            vibratorManager.cancel()
        }
    }

}