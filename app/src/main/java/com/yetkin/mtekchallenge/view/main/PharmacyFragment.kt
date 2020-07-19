package com.yetkin.mtekchallenge.view.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.data.model.City
import com.yetkin.mtekchallenge.data.model.CityList
import com.yetkin.mtekchallenge.data.model.DistrictList
import com.yetkin.mtekchallenge.databinding.FragmentPharmacyBinding
import com.yetkin.mtekchallenge.viewBinding
import com.yetkin.mtekchallenge.viewmodel.PharmacyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class PharmacyFragment : Fragment(R.layout.fragment_pharmacy) {

    private val pharmacyBinding: FragmentPharmacyBinding by viewBinding(FragmentPharmacyBinding::bind)
    private var cityList: ArrayList<String> = ArrayList()
    private var city: ArrayList<City> = ArrayList()
    private var districtList1: ArrayList<String> = ArrayList()
    private val gson = Gson()
    var citySelected = ""
    var districtSelected = ""
    private val pharmacyViewModel: PharmacyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadCity(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pharmacyBinding.apply {

            spinnerCity.setTitle("Select City")
            spinnerDistrict.setTitle("Select District")
            val cityListAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                cityList
            )
            spinnerCity.adapter = cityListAdapter

            spinnerCity.onItemSelectedListener = object : AdapterView.OnItemClickListener,
                AdapterView.OnItemSelectedListener {
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    citySelected = parent?.selectedItem.toString().toUpperCase()
                    districtList1.clear()
                    loadDistrict(requireContext(), city[position].sehirId)
                }
            }

            val districtAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                districtList1
            )
            spinnerDistrict.adapter = districtAdapter

            spinnerDistrict.onItemSelectedListener = object : AdapterView.OnItemClickListener,
                AdapterView.OnItemSelectedListener {
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    districtSelected = parent?.selectedItem.toString().toUpperCase()
                }

            }



            buttonList.setOnClickListener {

                if (citySelected.isNotEmpty() && districtSelected.isNotEmpty()) {
                    pharmacyViewModel.getPharmacy(citySelected, districtSelected)
                        .observe(viewLifecycleOwner,
                            Observer { list ->
                                list.forEach { pharmacy ->
                                    Log.e("Name : ", pharmacy.name)
                                }

                            })
                } else {
                    Log.e("Status : ", "EMPTY")
                }

            }


        }
    }

    fun loadCity(context: Context) {

        var cityList = CityList()
        val jsonCityReader =
            BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.city)))
        val jsonCityBuilder = StringBuilder()



        jsonCityReader.forEachLine { line ->
            jsonCityBuilder.append(line).append("\n")
        }

        cityList = gson.fromJson(jsonCityBuilder.toString(), CityList::class.java)
        for (i in cityList.cityDetail) {
            this.cityList.add(i.sehirAdi)
            this.city.add(i)
        }
    }

    fun loadDistrict(context: Context, sehirId: String) {
        var districtList = DistrictList()
        val jsonDistrictReader =
            BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.district)))
        val jsonDistrictBuilder = StringBuilder()

        jsonDistrictReader.forEachLine { line ->
            jsonDistrictBuilder.append(line).append("\n")
        }
        districtList = gson.fromJson(jsonDistrictBuilder.toString(), DistrictList::class.java)
        for (i in districtList.districtDetail) {
            if (i.sehirId == sehirId) {
                districtList1.add(i.ilceAdi)
            }
        }
    }
}