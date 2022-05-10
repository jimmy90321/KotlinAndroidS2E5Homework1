package com.jimmy.androidcircle.s2e5homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import com.jimmy.androidcircle.s2e5homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = MainAdapter {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(SecondActivity.KEY_SELECTED, it)
            }

            startActivity(intent)
        }

        binding.recyclerMain.apply {
            adapter = mAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, 5, GridLayoutManager.VERTICAL, false)
        }
    }
}