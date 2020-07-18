package com.yetkin.mtekchallenge.view.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.FragmentRegisterBinding
import com.yetkin.mtekchallenge.viewBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val registerBinding: FragmentRegisterBinding by viewBinding(FragmentRegisterBinding::bind)
    private lateinit var firebaseAut: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAut = FirebaseAuth.getInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerBinding.apply {

            buttonRegister.setOnClickListener {

                progressBar.visibility = View.VISIBLE

                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()

                email.apply {
                    if (contains("@hotmail.com") || contains("@gmail.com")) {

                        firebaseAut.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    editTextEmail.isFocusable = false
                                    editTextPassword.isFocusable = false
                                    Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
                                    progressBar.visibility = View.INVISIBLE
                                    NavHostFragment.findNavController(this@RegisterFragment)
                                        .navigate(R.id.action_registerFragment_to_loginFragment)
                                } else {
                                    Toast.makeText(
                                        context,
                                        it.exception?.message,
                                        Toast.LENGTH_LONG
                                    ).show()
                                    progressBar.visibility = View.INVISIBLE
                                }

                            }
                    } else {
                        Toast.makeText(context, "Email or password error", Toast.LENGTH_LONG).show()
                        progressBar.visibility = View.INVISIBLE
                    }

                }

            }
        }
    }

}