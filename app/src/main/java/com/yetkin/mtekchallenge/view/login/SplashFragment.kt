package com.yetkin.mtekchallenge.view.login

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.FragmentSplashBinding
import com.yetkin.mtekchallenge.viewBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val timer = object : CountDownTimer(1000, 1000) {
            override fun onFinish() {
                NavHostFragment.findNavController(this@SplashFragment)
                    .navigate(R.id.action_splashFragment2_to_loginFragment)
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
    }
}