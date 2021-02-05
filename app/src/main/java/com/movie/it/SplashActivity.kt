package com.movie.it

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    val glasses: ImageView by lazy {
        findViewById(R.id.glasses)
    }
    val popcorn: ImageView by lazy {
        findViewById(R.id.popcorn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()

        var animation = AnimationUtils.loadAnimation(this, R.anim.translate)
        glasses.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(this, R.anim.translate2)
        popcorn.startAnimation(animation)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 3000L)
    }
}