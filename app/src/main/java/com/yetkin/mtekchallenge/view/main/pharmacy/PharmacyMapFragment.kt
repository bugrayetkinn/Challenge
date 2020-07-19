package com.yetkin.mtekchallenge.view.main.pharmacy

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.FragmentPharmacyMapBinding
import com.yetkin.mtekchallenge.viewBinding
import java.util.*

class PharmacyMapFragment : Fragment(R.layout.fragment_pharmacy_map), OnMapReadyCallback {

    private val pharmacyMapBinding: FragmentPharmacyMapBinding by viewBinding(
        FragmentPharmacyMapBinding::bind
    )
    private lateinit var googleMap: GoogleMap
    private lateinit var geocoder: Geocoder
    private lateinit var adress: String
    private lateinit var location: Address
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        geocoder = Geocoder(requireContext())
        adress = arguments?.getString("adress", "").toString()

        var list: List<Address> = ArrayList()
        list = geocoder.getFromLocationName(adress, 1)

        if (list.isNotEmpty()) {
            location = list[0]
            Toast.makeText(
                requireContext(),
                "${location.latitude} + ${location.longitude}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pharmacyMapBinding.apply {
            mapView.onCreate(savedInstanceState)
            mapView.onResume()
            mapView.getMapAsync(this@PharmacyMapFragment)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        val loc = LatLng(location.latitude, location.longitude)
        this.googleMap.addMarker(MarkerOptions().position(loc).title("Target"))
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 14.0F))
    }

}