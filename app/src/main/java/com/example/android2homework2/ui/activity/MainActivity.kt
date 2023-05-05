package com.example.android2homework2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.android2homework2.R
import com.example.android2homework2.databinding.ActivityMainBinding
import com.example.android2homework2.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
        val check = preferenceHelper.saveBoolean

        if (check == false) {
            navController.navigate(R.id.onBoardFragment)
        } else {
            navController.navigate(R.id.homeFragment)

        }
    }
}