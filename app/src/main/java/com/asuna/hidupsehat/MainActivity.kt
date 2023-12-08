package com.asuna.hidupsehat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asuna.hidupsehat.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class CardItem(val imageResId: Int, val text: String)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNav
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val dataList = listOf(
            CardItem(R.drawable.ellips1, "Yoga"),
            CardItem(R.drawable.ellips5, "Gym"),
            CardItem(R.drawable.ellips4, "Cardio"),
            CardItem(R.drawable.ellips3, "Stretch"),
            CardItem(R.drawable.ellips2, "Full Body")
        )

        val adapter = CardAdapter(dataList)
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
    }
}
