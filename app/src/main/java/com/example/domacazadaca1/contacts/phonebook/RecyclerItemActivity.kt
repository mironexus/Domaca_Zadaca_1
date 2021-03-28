package com.example.domacazadaca1.contacts.phonebook

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.domacazadaca1.databinding.ActivityRecyclerItemBinding
import com.google.android.material.appbar.CollapsingToolbarLayout


private lateinit var binding: ActivityRecyclerItemBinding

class RecyclerItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.name.text = intent.getStringExtra("name")
        binding.surname.text = intent.getStringExtra("surname")
        binding.age.text = String.format("%d", intent.getIntExtra("age", 0))

    }
}