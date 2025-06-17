package com.tops.eventmange

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tops.eventmange.databinding.ActivitySplashScreenBinding
import com.tops.eventmange.fragments.IS_LOGIN

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)
        val isLogin= sharedPref.getBoolean(IS_LOGIN,false)
        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin == true){
                val intent = Intent(this , DrawerDashboardActivity::class.java)
                startActivity(intent)
            }else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            }
        },3000)
    }

}