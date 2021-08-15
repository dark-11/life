package com.lifetap.assignment.ui.bubble.item


import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.databinding.ObservableInt
import com.lifetap.assignment.base.BaseViewModel
import com.lifetap.assignment.utils.Border
import com.lifetap.assignment.utils.CircleAnimation

/**
 * ViewModel to handle the Item ViewModel of RecyclerView
 */

class ManageBubbleItemViewModel : BaseViewModel() {
    lateinit var delegate: ItemViewModelDelegate
    fun init() {
        var border = Border(delegate.ctx)
        border!!.loaded = false
    }


    fun onImageClick(view: View) {
        val border = view as? Border
        border!!.loaded = true
        val animation = CircleAnimation(border!!, 360)
        animation.duration = 1000
        border!!.startAnimation(animation)
        delegate.onImageClick()
    }
}