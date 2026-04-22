package ru.vafeen.flowers_screen.flower_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import ru.vafeen.common.toDp
import ru.vafeen.flowers_screen.R
import kotlin.properties.Delegates

internal class FlowerView @JvmOverloads constructor(
//    Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes
    private val context: Context,
    private val attributeSet: AttributeSet? = null,
    defStyleAttr: Int = R.attr.FlowerStyle,
    defStyleRes: Int = R.style.DefaultFlowerStyle
) : View(context, attributeSet, defStyleAttr, defStyleRes) {
    private val heightF
        get() = height.toFloat()
    private val widthF
        get() = width.toFloat()
    private var flowerColor: Int by Delegates.notNull()
    private var flowerName: String by Delegates.notNull()
    private val flowerBudPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val flowerStemPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val flowerSheetPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val flowerBudPath = Path()
    private val flowerStemPath = Path()
    private val flowerSheetsPath = Path()
    private val flowerStemWidth: Float
        get() = widthF / 30f

    init {
        if (attributeSet != null) {
            initAttributes(attributeSet, defStyleAttr, defStyleRes)
        } else {
            initDefaultAttributes()
        }
        initPaints()
    }

    private fun initAttributes(
        attributeSet: AttributeSet,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) {
        context.withStyledAttributes(
            attributeSet,
            R.styleable.FlowerView,
            defStyleAttr,
            defStyleRes
        ) {
            flowerColor = this.getColor(R.styleable.FlowerView_flowerColor, DEFAULT_FLOWER_COLOR)
            flowerName = this.getString(R.styleable.FlowerView_flowerName) ?: DEFAULT_FLOWER_NAME
        }
    }

    private fun initDefaultAttributes() {
        flowerColor = DEFAULT_FLOWER_COLOR
        flowerName = DEFAULT_FLOWER_NAME
    }

    private fun initPaints() {
        flowerBudPaint.style = Paint.Style.FILL
        flowerBudPaint.color = flowerColor
        flowerBudPaint.strokeWidth = context.toDp(1f)

        flowerSheetPaint.style = Paint.Style.FILL
        flowerSheetPaint.color = Color.GREEN
        flowerSheetPaint.strokeWidth = context.toDp(5f)

        flowerStemPaint.style = Paint.Style.STROKE
        flowerStemPaint.color = Color.GREEN
//        flowerStemPaint.strokeWidth = context.toDp(flowerStemWidth)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val minWidth = suggestedMinimumWidth + paddingStart + paddingEnd
//        val minHeight = suggestedMinimumHeight + paddingTop + paddingBottom
//        setMeasuredDimension(
//            resolveSize(minWidth, widthMeasureSpec),
//            resolveSize(minHeight, heightMeasureSpec)
//        )
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawBud(canvas)
        drawStem(canvas)
        drawSheets(canvas)
    }

    private fun drawBud(canvas: Canvas) {

        flowerBudPath.reset()
        val startX = widthF / 4
        val startY = heightF * 0.05f

        val countOfSheet = 10
        flowerBudPath.moveTo(startX, startY)
        val sheetWidth = widthF / 2 / countOfSheet
        repeat(countOfSheet) {
            flowerBudPath.arcTo(
                startX + sheetWidth * it,
                0f,
                startX + sheetWidth * (it + 1),
                startY * 2,
                180f,
                180f,
                true
            )
        }


        val endX = widthF * 3 / 4
        val endY = heightF / 3

        val deltaY = (endY - startY)
        flowerBudPath.addArc(
            startX,
            startY - deltaY,
            endX,
            startY + deltaY,
            180f,
            -180f
        )

        canvas.drawPath(flowerBudPath, flowerBudPaint)
    }

    private fun drawStem(canvas: Canvas) {
        flowerStemPaint.strokeWidth = context.toDp(flowerStemWidth)
        val controlX = widthF / 2
        val controlY = heightF / 3
        flowerStemPath.reset()
        flowerStemPath.moveTo(controlX, controlY)
//        flowerStemPath.moveTo(0f,0f)
        flowerStemPath.lineTo(controlX, heightF)


        canvas.drawPath(flowerStemPath, flowerStemPaint)
    }

    private fun drawSheets(canvas: Canvas) {
        val half = flowerStemPaint.strokeWidth / 2f
        flowerSheetsPath.reset()
        flowerSheetsPath.addArc(
            widthF / 2 + half,
            heightF * 0.4f,
            widthF * 0.9f + half,
            heightF * 0.55f,
            -180f,
            180f
        )

        flowerSheetsPath.addArc(
            widthF / 10 - half,
            heightF * 0.6f,
            widthF / 2 - half,
            heightF * 0.75f,
            -180f,
            180f
        )

        canvas.drawPath(flowerSheetsPath, flowerSheetPaint)
    }

    fun setColor(color: Int) {
        flowerColor = color
        flowerBudPaint.color = flowerColor
        invalidate()
    }

    companion object {
        const val DEFAULT_FLOWER_COLOR = Color.RED
        const val DEFAULT_FLOWER_NAME = "DEFAULT_FLOWER_NAME"
    }
}