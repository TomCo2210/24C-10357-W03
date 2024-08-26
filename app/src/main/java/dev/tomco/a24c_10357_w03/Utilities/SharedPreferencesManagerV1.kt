package dev.tomco.a24c_10357_w03.Utilities

import android.content.Context

object SharedPreferencesManagerV1 {

    fun putString(context: Context, key: String, value: String) {
        val sharedPref =
            context.getSharedPreferences(Constants.DATA_KEY, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(context: Context, key: String, defaultValue: String): String {
        val sharedPref =
            context.getSharedPreferences(Constants.DATA_KEY, Context.MODE_PRIVATE) ?: return defaultValue
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }
}