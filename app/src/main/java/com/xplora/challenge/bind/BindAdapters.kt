package com.xplora.challenge.bind

import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.textview.MaterialTextView
import com.xplora.challenge.helpers.DebugLog
import com.xplora.challenge.network.RetrofitBuilder

class BindAdapters {

    companion object {

        @BindingAdapter("imageUrl")
        @JvmStatic
        fun imageUrl(imageView: ImageView, url: String?) {

            val imageUrl = RetrofitBuilder.BASE_URL.plus(url)
            DebugLog.e("image url ==> $imageUrl")
            Glide.with(imageView.context)
                .load(imageUrl)
                .centerCrop()
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {

                        return true
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        imageView.setImageDrawable(resource)
                        return true
                    }
                })
                .into(imageView)
        }

        @BindingAdapter("htmlText")
        @JvmStatic
        fun setHtmlTextValue(textView: MaterialTextView, htmlText: String?) {
            if (htmlText == null) return
            val result: Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
            } else {
                Html.fromHtml(htmlText)
            }
            textView.text = result
        }
    }
}