package com.lifetap.assignment.utils

import android.view.animation.Animation
import android.view.animation.Transformation

/**
 * Animation class to move the paint from oldAngle to newAngle
 */
class CircleAnimation(circle: Border, newAngle: Int) : Animation() {
    private val circle: Border
    private val oldAngle: Float
    private val newAngle: Float
    override fun applyTransformation(interpolatedTime: Float, transformation: Transformation?) {
        super.applyTransformation(interpolatedTime, transformation)
        val angle = oldAngle + (newAngle - oldAngle) * interpolatedTime
        circle.angle = angle
        circle.requestLayout()

    }

    init {
        oldAngle = circle.angle!!
        this.newAngle = newAngle.toFloat()
        this.circle = circle
    }
}