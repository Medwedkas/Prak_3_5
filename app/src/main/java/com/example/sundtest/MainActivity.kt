package com.example.sundtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentReplace()
    }

    fun fragmentReplace() {
        val button = findViewById<Button>(R.id.caption)
        button.setOnClickListener {
            val red = RedFragment()
            val blue = BlueFragment()
            val manager = supportFragmentManager
            val translation = manager.beginTransaction()
            val translation2 = manager.beginTransaction()
            if (count == 0) {
                translation.replace(R.id.RedFragment, blue)
                translation.commit()
                translation2.replace(R.id.BlueFragment, red)
                translation2.commit()
                count++
            } else {
                translation.replace(R.id.RedFragment, red)
                translation.commit()
                translation2.replace(R.id.BlueFragment, blue)
                translation2.commit()
                count = 0
            }
        }
    }
}