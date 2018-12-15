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
val sizeFactor : Int = 6
val color : Int = Color.parseColor("#3498db")
val scGap : Float = 0.05f
val scDiv : Double = 0.51

fun Int.getInverse() : Float = 1f / this

fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.getInverse(), Math.max(0f, this - i * n.getInverse())) * n

fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()

fun Float.mirrorValue(a : Int, b : Int) : Float = (1 - scaleFactor()) * a.getInverse() + scaleFactor() * b.getInverse()

fun Float.updateScale(dir : Float, a : Int, b : Int) : Float = dir * scGap * mirrorValue(a, b)
