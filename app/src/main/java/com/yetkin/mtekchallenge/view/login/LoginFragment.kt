package com.yetkin.mtekchallenge.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.FragmentLoginBinding
import com.yetkin.mtekchallenge.view.main.MainActivity
import com.yetkin.mtekchallenge.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val loginFragmentBinding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginFragmentBinding.apply {

            buttonLogin.setOnClickListener {

                progressBar.visibility = View.VISIBLE

                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

                        if (it.isSuccessful) {
                            startActivity(Intent(activity, MainActivity::class.java))
                        } else {
                            Toast.makeText(context, it.exception?.message, Toast.LENGTH_LONG).show()
                            Log.e("FirebaseError : ", it.exception?.message)
                        }
                        progressBar.visibility = View.INVISIBLE
                    }
                } else {
                    Toast.makeText(context, "Email or password error", Toast.LENGTH_LONG).show()
                    progressBar.visibility = View.INVISIBLE
                }


            }

            textViewRegister.setOnClickListener {
                editTextEmail.text?.clear()
                editTextPassword.text?.clear()
                NavHostFragment.findNavController(this@LoginFragment)
                    .navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }
}