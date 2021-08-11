package com.lifetap.assignment.ui.bubble.item


import android.view.View
import androidx.databinding.ObservableInt
import com.lifetap.assignment.R
import com.lifetap.assignment.base.BaseViewModel
import com.lifetap.assignment.utils.CircleAngleAnimation
import com.lifetap.assignment.utils.CircleView


class ManageBubbleItemViewModel : BaseViewModel() {
    lateinit var delegate: ItemViewModelDelegate
    fun onImageClick(view: View) {
        val circle = view as? CircleView

        val animation = CircleAngleAnimation(circle!!, 360)
        animation.duration = 1000
        circle.startAnimation(animation)
    }
}