package com.lifetap.assignment.utils

import android.content.res.Resources
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.lifetap.assignment.R

@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    try {
        imageView.setImageResource(resource)
    }catch (ex: Resources.NotFoundException){
        imageView.setImageResource(R.drawable.dummy)
    }
}
