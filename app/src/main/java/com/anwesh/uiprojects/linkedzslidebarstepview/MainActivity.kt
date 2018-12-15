package com.anwesh.uiprojects.linkedzslidebarstepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.zslidebarstepview.ZSlideBarStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ZSlideBarStepView.create(this)
    }
}
