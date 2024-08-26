package dev.tomco.a24c_10357_w03.Utilities

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManagerV2(context: Context) {
    private val sharedPref: SharedPreferences

    init {
        this.sharedPref =
            context.getSharedPreferences(Constants.DATA_KEY, Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String) {
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }
}