package dev.tomco.a24c_10357_w03.Utilities

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.constraintlayout.widget.Placeholder
import com.bumptech.glide.Glide
import dev.tomco.a24c_10357_w03.R
import dev.tomco.a24c_10357_w03.Utilities.SharedPreferencesManagerV3.Companion

class ImageLoader private constructor(private val context: Context) {

    fun load(
        source: Drawable,
        imageView: ImageView,
        placeholder: Int = R.drawable.unavailable_photo
    ) {
        Glide
            .with(context)
            .load(source)
            .placeholder(placeholder)
            .centerCrop()
            .into(imageView)
    }

    fun load(
        source: String,
        imageView: ImageView,
        placeholder: Int = R.drawable.unavailable_photo
    ) {
        Glide
            .with(context)
            .load(source)
            .placeholder(placeholder)
            .centerCrop()
            .into(imageView)
    }

    companion object {

        @Volatile
        private var instance: ImageLoader? = null

        fun init(context: Context): ImageLoader {
            return instance ?: synchronized(this) {
                instance ?: ImageLoader(context).also { instance = it }
            }
        }

        fun getInstance(): ImageLoader {
            return instance
                ?: throw IllegalStateException("ImageLoader must be initialized by calling init(context) before use.")
        }
    }


}