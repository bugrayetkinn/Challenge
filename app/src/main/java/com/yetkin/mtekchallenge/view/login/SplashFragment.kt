package com.yetkin.mtekchallenge.view.login

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.yetkin.mtekchallenge.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : CountDownTimer(3500, 1000) {
            override fun onFinish() {
                NavHostFragment.findNavController(this@SplashFragment)
                    .navigate(R.id.action_splashFragment2_to_loginFragment)
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
    }
}