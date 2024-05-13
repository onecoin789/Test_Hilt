package com.example.teamproject_11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teamproject_11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val bidning by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(bidning.root)

    }
}

