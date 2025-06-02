package com.tops.eventmange

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tops.eventmange.databinding.ActivityMainBinding
import com.tops.eventmange.fragments.IntroFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        val sharedPref = getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)
//        val IS_LOGIN = "IS_LOGIN"
//        val isLogin= sharedPref.getBoolean(IS_LOGIN,false)
        // SharedPreferences :- Save data in Local Database-(In Device Only)
        // To checkk data manually as a developer-> goto "Device Manager"-> click ":" three dots
        // Now goto-> Data -> data -> find your package name -> fid Shared-preference ->
        // ---> ( File name given to shared preferences )== here we have given as app_name("EventMange")


       binding.root.post {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<IntroFragment>(R.id.mainactivity_fragment)
            }
        }

//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            add<IntroFragment>(R.id.mainactivity_fragment)
//        }

    }

}