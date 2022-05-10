package com.jimmy.androidcircle.s2e5homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.jimmy.androidcircle.s2e5homework.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object{
        const val KEY_SELECTED = "selected_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val selectedItem = intent.extras?.getInt(KEY_SELECTED)
        binding.tvResult.text = selectedItem?.toString()
    }
}