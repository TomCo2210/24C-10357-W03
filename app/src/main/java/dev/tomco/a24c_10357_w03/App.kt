package dev.tomco.a24c_10357_w03

import android.app.Application
import dev.tomco.a24c_10357_w03.Utilities.ImageLoader
import dev.tomco.a24c_10357_w03.Utilities.SharedPreferencesManagerV3
import dev.tomco.a24c_10357_w03.Utilities.SignalManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferencesManagerV3.init(this)
        ImageLoader.init(this)
        SignalManager.init(this)
    }
}