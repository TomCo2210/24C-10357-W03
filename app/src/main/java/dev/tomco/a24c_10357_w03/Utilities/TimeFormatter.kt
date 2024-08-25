package dev.tomco.a24c_10357_w03.Utilities


object TimeFormatter {
    fun formatTime(currentTimeDelta: Long): String {
        var seconds = (currentTimeDelta / 1000).toInt()
        var minutes = seconds / 60
        seconds %= 60
        var hours = minutes / 60
        minutes %= 60
        hours %= 24
        return buildString {
            append(String.format(locale = null, format = "%02d", hours))
            append(":")
            append(String.format(locale = null, format = "%02d", minutes))
            append(":")
            append(String.format(locale = null, format = "%02d", seconds))
        }
    }
}