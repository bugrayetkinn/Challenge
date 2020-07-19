package com.yetkin.mtekchallenge.view.main.pharmacy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.FragmentPharmacyMapBinding
import com.yetkin.mtekchallenge.viewBinding

class PharmacyMapFragment : Fragment(R.layout.fragment_pharmacy_map) {

    val pharmacyMapBinding: FragmentPharmacyMapBinding by viewBinding(FragmentPharmacyMapBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pharmacyMapBinding.apply {

        }
    }

}