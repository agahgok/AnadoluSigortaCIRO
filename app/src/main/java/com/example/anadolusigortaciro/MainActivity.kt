package com.example.anadolusigortaciro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.anadolusigortaciro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment
                || destination.id == R.id.pawSafeFragment
                || destination.id == R.id.insuranceServiceFragment
                || destination.id == R.id.profileFragment
                || destination.id == R.id.petsagramFragment
                || destination.id == R.id.feedCalendarFragment
                || destination.id == R.id.petVaccineStateFragment
            ) {
                binding.bottomNav.visibility = View.VISIBLE
            }
            else
                binding.bottomNav.visibility = View.GONE
        }
    }
}