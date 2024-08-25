package dev.tomco.a24c_10357_w03

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textview.MaterialTextView
import dev.tomco.a24c_10357_w03.Utilities.Constants
import dev.tomco.a24c_10357_w03.Utilities.TimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var main_LBL_time: MaterialTextView
    private lateinit var main_FAB_start: ExtendedFloatingActionButton
    private lateinit var main_FAB_stop: ExtendedFloatingActionButton

    val handler: Handler = Handler(Looper.getMainLooper())
    private var startTime: Long = 0
    private var timerOn = false

    val runnable: Runnable = object : Runnable {
        override fun run() {
            //reschedule
            handler.postDelayed(this, Constants.DELAY)
            //update ui
            updateTimerUI()
        }
    }

    private fun updateTimerUI() {
        val currentTime = System.currentTimeMillis()
        main_LBL_time.text = TimeFormatter.formatTime(currentTime - startTime)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        initViews()

    }

    private fun findViews() {
        main_LBL_time = findViewById(R.id.main_LBL_time)
        main_FAB_start = findViewById(R.id.main_FAB_start)
        main_FAB_stop = findViewById(R.id.main_FAB_stop)
    }

    private fun initViews() {
        main_FAB_start.setOnClickListener { v -> startTimer() }
        main_FAB_stop.setOnClickListener { v -> stopTimer() }
    }

    private fun stopTimer() {
        timerOn = false
        handler.removeCallbacks(runnable)
    }

    private fun startTimer() {
        if (!timerOn) {
            startTime = System.currentTimeMillis()
            handler.postDelayed(runnable, 0)
            timerOn = true
        }
    }
}