package dev.tomco.a24c_10357_w03

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class ToastAndVibrateActivity : AppCompatActivity() {
    private lateinit var tav_IMG_background: AppCompatImageView
    private lateinit var tav_BTN_tav: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_and_vibrate)

        findViews()
        initViews()
    }

    private fun initViews() {
        Glide
            .with(this)
//            .load(R.drawable.colosseum)
            .load("https://static.toiimg.com/thumb/msid-79608505,width-748,height-499,resizemode=4,imgsize-1624884/.jpg")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(tav_IMG_background);
        tav_BTN_tav.setOnClickListener { v -> toastAndVibrate("Hello Toast Message!") }
    }

    private fun toastAndVibrate(text: String) {
        toast(text)
        vibrate()
    }

    private fun vibrate() {
        val vibrator: Vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                this.getSystemService(VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            this.getSystemService(VIBRATOR_SERVICE) as Vibrator
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val sosPattern = longArrayOf(
                0,
                200,
                100,
                200,
                100,
                200,
                300,
                500,
                100,
                500,
                100,
                500,
                300,
                200,
                100,
                200,
                100,
                200
            )
            val waveVibrationEffect = VibrationEffect.createWaveform(
                sosPattern,
                -1
            )

            val oneShotVibrationEffect = VibrationEffect.createOneShot(
                500,
                VibrationEffect.DEFAULT_AMPLITUDE
            )
            vibrator.vibrate(waveVibrationEffect)
        } else {
            vibrator.vibrate(500)
        }
    }

    private fun toast(text: String) {
        Toast
            .makeText(
                this,
                text,
                Toast.LENGTH_LONG
            ).show()
    }

    private fun findViews() {
        tav_IMG_background = findViewById(R.id.tav_IMG_background)
        tav_BTN_tav = findViewById(R.id.tav_BTN_tav)
    }
}