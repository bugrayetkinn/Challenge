package com.yetkin.mtekchallenge.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.fragments?.forEach {
            it.onActivityResult(requestCode, resultCode, data)
        }

        for (fragment: Fragment in supportFragmentManager.fragments) {
            fragment.onActivityResult(requestCode, resultCode, data)
        }
    }

//    fun onExitClick(view: View) {
//        Toast.makeText(view.context, "Tıklandı", Toast.LENGTH_LONG).show()
//    }
}