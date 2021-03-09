package com.yusril.submission_pemula

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({ move() },3000)
    }

    private fun move(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}