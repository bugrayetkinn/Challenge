package com.yetkin.mtekchallenge.view.main.profil

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.yetkin.mtekchallenge.MyAlertDialog
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.AlertDesignBinding
import com.yetkin.mtekchallenge.databinding.FragmentProfilBinding
import com.yetkin.mtekchallenge.viewBinding

class ProfilFragment : Fragment(R.layout.fragment_profil) {

    val fragmentProfilBinding: FragmentProfilBinding by viewBinding(FragmentProfilBinding::bind)
    lateinit var imageUserPhoto: ImageView
    lateinit var myAlertDialog: MyAlertDialog
    lateinit var alertDesignBinding: AlertDesignBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alertDesignBinding = AlertDesignBinding.inflate(LayoutInflater.from(requireContext()))

        fragmentProfilBinding.apply {
            myAlertDialog = MyAlertDialog(root.context)
            imageUserPhoto = imageViewUserImage

            val email = activity?.getSharedPreferences("shared", Context.MODE_PRIVATE)
                ?.getString("email", "empty")

            textViewEmail.text = email

            buttonResetPw.setOnClickListener {
                myAlertDialog.createAlert(alertDesignBinding.root)
                alertDesignBinding.buttonSaveAlert.setOnClickListener {

                    val mail = alertDesignBinding.editTextEmailAlert.text.toString()
                    if (mail.isNotEmpty()) {
                        FirebaseAuth.getInstance().sendPasswordResetEmail(mail)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Fail", Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                        myAlertDialog.dialog.dismiss()
                    }
                }
                alertDesignBinding.buttonCloseAlert.setOnClickListener {
                    myAlertDialog.dialog.dismiss()
                }

            }

            imageViewUserImage.setOnClickListener {
                if (ContextCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        requireActivity(),
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        101
                    )
                } else {
                    val intentToGallery =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivity(intentToGallery)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 101 && resultCode == Activity.RESULT_OK && data != null) {
            val uri = data.data

            if (Build.VERSION.SDK_INT >= 28) {
                val source: ImageDecoder.Source? =
                    uri?.let { ImageDecoder.createSource(requireActivity().contentResolver, it) }
                val selectedImage = source?.let { ImageDecoder.decodeBitmap(it) }
                imageUserPhoto.setImageBitmap(selectedImage)
            } else {
                imageUserPhoto.setImageURI(uri)
            }
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 100) {

            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivity(intentToGallery)
            }
        }
    }


}