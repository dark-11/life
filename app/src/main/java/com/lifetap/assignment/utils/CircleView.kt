package com.lifetap.assignment.utils

import android.R
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import java.util.*


class CircleView : AppCompatImageView {
    private var mBasePaint: Paint? = null
    private var mDegreesPaint: Paint? = null
    private var mCenterPaint: Paint? = null
    private var mRectPaint: Paint? = null
    private var mRect: RectF? = null
    private var centerX = 0
    private var centerY = 0
    private var radius = 0
    private var image: Bitmap? = null
    var angle = 0F
    private var shader: BitmapShader? = null

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun loadBitmap() {
        val bitmapDrawable = this.drawable as BitmapDrawable
        if (bitmapDrawable != null) image = bitmapDrawable.bitmap
    }

    private fun init() {
        mCenterPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mCenterPaint!!.color = ContextCompat.getColor(context, R.color.white)
        mCenterPaint!!.style = Paint.Style.FILL
        mBasePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mBasePaint!!.style = Paint.Style.STROKE
        mBasePaint!!.strokeWidth = STROKE_WIDTH.toFloat()
        mBasePaint!!.color = ContextCompat.getColor(context, R.color.white)
        val rnd = Random()
        var color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        mDegreesPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mDegreesPaint!!.style = Paint.Style.STROKE
        mDegreesPaint!!.strokeWidth = STROKE_WIDTH.toFloat()
        mDegreesPaint!!.color = (color)
        this.invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        loadBitmap()
        if (image != null) {
            shader = BitmapShader(
                Bitmap.createScaledBitmap(image!!, canvas.width, canvas.height, false),
                Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP
            )
            mCenterPaint!!.shader = shader
            if (mRect == null) {
                centerX = getMeasuredWidth() / 2
                centerY = getMeasuredHeight() / 2
                radius = Math.min(centerX, centerY)

                val startTop = STROKE_WIDTH / 2
                val endBottom = 2 * radius - startTop
                mRect = RectF(
                    startTop.toFloat(), startTop.toFloat(), endBottom.toFloat(),
                    endBottom.toFloat()
                )
            }


            canvas.drawCircle(
                centerX.toFloat(),
                centerY.toFloat(),
                (radius - STROKE_WIDTH / 2).toFloat(), mBasePaint!!
            )

            canvas.drawArc(mRect!!, 90f, angle, false, mDegreesPaint!!)

            canvas.drawCircle(
                centerX.toFloat(),
                centerY.toFloat(),
                (radius - STROKE_WIDTH).toFloat(), mCenterPaint!!
            )
        }
    }

    companion object {
        private const val STROKE_WIDTH =10
    }
}
