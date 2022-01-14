package org.miraiexplorer.sugar

import android.app.WallpaperManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.core.view.ViewCompat
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSet = findViewById<View>(R.id.btn_wp) as Button
        btnSet.setOnClickListener { setWallpaper() }
    }
    private fun setWallpaper() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable._34453510c8c1644901aff391666a02aefe6c98f3)
        val manager = WallpaperManager.getInstance(applicationContext)
        try {
            manager.setBitmap(bitmap)
            Toast.makeText(this, "设置成功！！", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(this, "设置出错！！", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus) hideSystemUI()
    }
    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                )
    }
    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }
}
