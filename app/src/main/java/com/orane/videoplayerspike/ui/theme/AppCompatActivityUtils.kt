package com.orane.videoplayerspike.ui.theme

import android.view.Window
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat


fun Window.hideSystemUI() {
    val controller = WindowInsetsControllerCompat(this, this.decorView)
    controller.hide(WindowInsetsCompat.Type.systemBars())
    controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
}
fun Window.showSystemUI() {
    val controller = WindowInsetsControllerCompat(this, this.decorView)
    controller.show(WindowInsetsCompat.Type.systemBars())
}


