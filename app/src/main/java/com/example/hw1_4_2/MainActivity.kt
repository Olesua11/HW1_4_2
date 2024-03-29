package com.example.hw1_4_2

import TaskUpdateListener
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hw1_4_2.databinding.ActivityMainBinding
import com.example.hw1_4_2.ui.home.HomeFragment

class MainActivity : AppCompatActivity(), TaskUpdateListener {




    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun updateTask(position: Int, updatedTask: String) {
        val homeFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        if (homeFragment is HomeFragment) {
            homeFragment.updateTask(position, updatedTask)
        }
    }
}
