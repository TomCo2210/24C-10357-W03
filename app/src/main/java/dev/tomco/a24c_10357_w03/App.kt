package dev.tomco.a24c_10357_w03

import android.app.Application
import dev.tomco.a24c_10357_w03.Utilities.ImageLoader
import dev.tomco.a24c_10357_w03.Utilities.SharedPreferencesManagerV3

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferencesManagerV3.init(this)
        ImageLoader.init(this)
    }
}