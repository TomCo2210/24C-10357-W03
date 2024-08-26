package dev.tomco.a24c_10357_w03

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import dev.tomco.a24c_10357_w03.Models.Playlist
import dev.tomco.a24c_10357_w03.Utilities.Constants
import dev.tomco.a24c_10357_w03.Utilities.DataManager
import dev.tomco.a24c_10357_w03.Utilities.SharedPreferencesManagerV1
import dev.tomco.a24c_10357_w03.Utilities.SharedPreferencesManagerV2
import dev.tomco.a24c_10357_w03.Utilities.SharedPreferencesManagerV3
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create the playlist.

        // val playlist: Playlist = DataManager.generatePlaylist()
        val gson = Gson()
        // val playlistAsJson: String = gson.toJson(playlist)

        // Log.d("playlistAsJson", "playlistAsJson: " + playlistAsJson)

        //SharedPreferencesManagerV1.putString(this, Constants.PLAYLIST_KEY, playlistAsJson)

        //v2:
        // val spmv2: SharedPreferencesManagerV2 = SharedPreferencesManagerV2(this)
        // spmv2.putString(Constants.PLAYLIST_KEY, playlistAsJson)

        //v3:
        // SharedPreferencesManagerV3.getInstance().putString(Constants.PLAYLIST_KEY, playlistAsJson)

        //read from shared preferences to String
        //v1:
        //val playlistFromSP = SharedPreferencesManagerV1.getString(this, Constants.PLAYLIST_KEY, "")
        //Log.d("playlistFromSP", "playlistFromSP: " + playlistFromSP)


        //v2:
        // val playlistFromSP = spmv2.getString(Constants.PLAYLIST_KEY, "")
        // Log.d("playlistFromSP", "playlistFromSP: " + playlistFromSP)

        //v3:
        val playlistFromSP = SharedPreferencesManagerV3
            .getInstance()
            .getString(Constants.PLAYLIST_KEY, "")
        Log.d("playlistFromSP", "playlistFromSP: " + playlistFromSP)

        val playlistObjFromSP: Playlist = gson.fromJson(playlistFromSP, Playlist::class.java)
        Log.d("playlistObjFromSP", "playlistObjFromSP: " + playlistObjFromSP)
    }
}