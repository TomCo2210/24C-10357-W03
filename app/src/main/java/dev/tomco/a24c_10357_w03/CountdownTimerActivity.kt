package dev.tomco.a24c_10357_w03

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textview.MaterialTextView
import dev.tomco.a24c_10357_w03.Utilities.Constants
import dev.tomco.a24c_10357_w03.Utilities.TimeFormatter

class CountdownTimerActivity : AppCompatActivity() {

    private lateinit var main_LBL_time: MaterialTextView
    private lateinit var main_FAB_start: ExtendedFloatingActionButton
    private lateinit var main_FAB_stop: ExtendedFloatingActionButton

    private var startTime: Long = 0
    private var timerOn = false
    private lateinit var countDownTimer: CountDownTimer

    private fun updateTimerUI() {
        val currentTime = System.currentTimeMillis()
        main_LBL_time.text = TimeFormatter.formatTime(currentTime - startTime)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

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
        countDownTimer.cancel()
    }

    private fun startTimer() {
        if (!timerOn) {
            timerOn = true
            startTime = System.currentTimeMillis()
            countDownTimer = object : CountDownTimer(6000, Constants.DELAY) {
                override fun onTick(millisUntilFinished: Long) {
                    updateTimerUI()
                }

                override fun onFinish() {
                    timerOn = false
                }
            }.start()
        }
    }
}