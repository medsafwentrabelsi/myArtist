package com.famileo.myartist.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.famileo.myartist.databinding.ActivityMainBinding

/**
 * The main activity.
 * */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
    }
}