package com.yetkin.mtekchallenge.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.apply {
            val toggle = ActionBarDrawerToggle(this@MainActivity, drawer, toolbar, 0, 0)
            toggle.syncState()
        }

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
        NavigationUI.setupWithNavController(mainBinding.bottomNavigation, navController)
        NavigationUI.setupWithNavController(mainBinding.navigation, navController)

    }
}