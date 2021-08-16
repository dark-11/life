package com.lifetap.assignment.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.util.SparseIntArray
import android.view.View
import com.lifetap.assignment.R
import java.util.*

/**
 * Creating border class for View
 */
class Border : View {
    private var radius = 0f
    private var spaceWidth = SPACE_WIDTH
    private var spacing = SPACING
    private var color = DEFAULT_COLOR
    private var count = COUNT
    private val mBorderRect = RectF()
    private var paint: Paint? = null
    private val portionToUpdateMap = SparseIntArray()
    var angle = 0f
    var loaded = false

    constructor(context: Context) : super(context) {
        init(context, null, -1)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CircularView, defStyle, 0)
        if (typedArray != null) {
            color = typedArray.getColor(R.styleable.CircularView_color, DEFAULT_COLOR)
            spaceWidth = typedArray.getDimensionPixelSize(
                R.styleable.CircularView_width,
                spaceWidth.toInt()
            ).toFloat()
            spacing = typedArray.getDimensionPixelSize(
                R.styleable.CircularView_spacing,
                spacing
            )
            count =
                typedArray.getInteger(R.styleable.CircularView_count, count.toInt())
                    .toFloat()
            typedArray.recycle()
        }
        paint = getPaint()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs, -1)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mBorderRect.set(calculateBounds())
        radius = Math.min(
            (mBorderRect.height() - spaceWidth) / 2.0f,
            (mBorderRect.width() - spaceWidth) / 2.0f
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = radius
        val center_x = mBorderRect.centerX()
        val center_y = mBorderRect.centerY()
        val oval = getOval(radius, center_x, center_y)
        val degree = 360 / count
        val percent = 100 / count
        clicked(oval, angle, paint, canvas, degree, percent)
    }

    fun clicked(
        rect: RectF?,
        angle: Float?,
        paint: Paint?,
        canvas: Canvas,
        degree: Float,
        percent: Float
    ) {
        if (loaded) {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            paint!!.color = color
            canvas.drawArc(rect!!, 90f, angle!!, false, paint)
        } else {
            var i = 0
            while (i < count) {
                paint!!.color = getPaintColorForIndex(i)
                val startAngle = DEGREE + degree * i
                canvas.drawArc(
                    rect!!,
                    getSpacing() / 2 + startAngle,
                    getProgressAngle(percent) - getSpacing(),
                    false,
                    paint
                )
                i++
            }
        }
    }

    private fun getPaintColorForIndex(i: Int): Int {
        return if (portionToUpdateMap.indexOfKey(i) >= 0) {
            portionToUpdateMap[i]
        } else {
            color
        }
    }

    private fun getOval(radius: Float, center_x: Float, center_y: Float): RectF {
        val oval = RectF()
        oval[center_x - radius, center_y - radius, center_x + radius] = center_y + radius
        return oval
    }

    private fun getPaint(): Paint {
        val paint = Paint()
        paint.color = color
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.strokeWidth = spaceWidth
        paint.strokeCap = Paint.Cap.ROUND
        return paint
    }

    private fun getSpacing(): Int {
        return if (count == 1f) 0 else spacing
    }

    private fun calculateBounds(): RectF {
        val availableWidth = width - paddingLeft - paddingRight
        val availableHeight = height - paddingTop - paddingBottom
        val sideLength = Math.min(availableWidth, availableHeight)
        val left = paddingLeft + (availableWidth - sideLength) / 2f
        val top = paddingTop + (availableHeight - sideLength) / 2f
        return RectF(left, top, left + sideLength, top + sideLength)
    }

    private fun getProgressAngle(percent: Float): Float {
        return percent / 100.toFloat() * 360
    }

    companion object {
        private const val SPACE_WIDTH = 10f
        private const val SPACING = 5
        private val DEFAULT_COLOR = Color.parseColor("#808080")
        private const val COUNT = 1f
        private const val DEGREE = -90f
    }


}