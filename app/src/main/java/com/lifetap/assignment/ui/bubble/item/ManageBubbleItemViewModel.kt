package com.lifetap.assignment.ui.bubble.item


import android.view.View
import com.lifetap.assignment.base.BaseViewModel
import com.lifetap.assignment.utils.CircleAnimation
import com.lifetap.assignment.utils.CircleView

/**
 * ViewModel to handle the Item ViewModel of RecyclerView
 */

class ManageBubbleItemViewModel : BaseViewModel() {
    lateinit var delegate: ItemViewModelDelegate
    fun onImageClick(view: View) {
        val circle = view as? CircleView

        val animation = CircleAnimation(circle!!, 360)
        animation.duration = 1000
        circle.startAnimation(animation)
    }
}