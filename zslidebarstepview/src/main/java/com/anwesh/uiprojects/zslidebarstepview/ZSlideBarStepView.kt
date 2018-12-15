package com.anwesh.uiprojects.zslidebarstepview

import android.graphics.Color
import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF
import android.app.Activity
import android.content.Context

/**
 * Created by anweshmishra on 15/12/18.
 */

val nodes : Int = 5
val bars : Int = 2
val sizeFactor : Int = 4
val color : Int = Color.parseColor("#3498db")
val scGap : Float = 0.05f
val scDiv : Double = 0.51

fun Int.getInverse() : Float = 1f / this

fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.getInverse(), Math.max(0f, this - i * n.getInverse())) * n

fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()

fun Float.mirrorValue(a : Int, b : Int) : Float = (1 - scaleFactor()) * a.getInverse() + scaleFactor() * b.getInverse()

fun Float.updateScale(dir : Float, a : Int, b : Int) : Float = dir * scGap * mirrorValue(a, b)


fun Canvas.drawZSBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    val wGap : Float = size / (bars + 1)
    save()
    translate(gap * (i + 1), h/2)
    rotate(90f * sc2)
    drawRect(-wGap/2, -size/2, wGap/2, size/2, paint)
    for (j in 0..(bars - 1)) {
        val sc : Float = sc1.divideScale(j, bars)
        save()
        translate(-wGap * (1 - 2 * j), -(1 - 2 * j) * size * sc)
        drawRect(RectF(-wGap/2, -size/2, wGap/2, size/2), paint)
        restore()
    }
    restore()
}