package com.lifetap.assignment.utils

import android.content.res.Resources
import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.lifetap.assignment.R

/**
 * Image Resource adapter
 */
@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    try {
        imageView.setImageResource(resource)
    }catch (ex: Resources.NotFoundException){
        imageView.setImageResource(R.drawable.dummy)
    }
}
