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
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import dev.tomco.a24c_10357_w03.Utilities.ImageLoader
import dev.tomco.a24c_10357_w03.Utilities.SignalManager

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
        ImageLoader
            .getInstance()
            .load(
//                ContextCompat.getDrawable(applicationContext,R.drawable.colosseum)!!, //Drawable
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Tel_Aviv_Port_Lowshot.jpg/1200px-Tel_Aviv_Port_Lowshot.jpg", //Link
                tav_IMG_background,
                R.drawable.unavailable_photo)
        tav_BTN_tav.setOnClickListener { v -> toastAndVibrate("Hello Toast Message!") }
    }

    private fun toastAndVibrate(text: String) {
        SignalManager.getInstance().toast(text)
        SignalManager.getInstance().vibrate()
    }



    private fun findViews() {
        tav_IMG_background = findViewById(R.id.tav_IMG_background)
        tav_BTN_tav = findViewById(R.id.tav_BTN_tav)
    }
}