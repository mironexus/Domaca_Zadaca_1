package com.example.domacazadaca1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.domacazadaca1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.setOnClickListener{
            binding.helloWorld.visibility = if (binding.helloWorld.visibility == View.VISIBLE) { View.INVISIBLE } else { View.VISIBLE }
            binding.toggleButton.text = if (binding.toggleButton.text == getString(R.string.hide)) { getString(R.string.show) } else { getString(R.string.hide) }
        }
    }
}