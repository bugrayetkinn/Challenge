package com.yetkin.mtekchallenge.adapter

import androidx.recyclerview.widget.RecyclerView
import com.yetkin.mtekchallenge.data.model.PharmacyModel
import com.yetkin.mtekchallenge.databinding.PharmacyCardBinding


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class PharmacyHolder(private val pharmacyCardBinding: PharmacyCardBinding) :
    RecyclerView.ViewHolder(pharmacyCardBinding.root) {

    fun bind(pharmacyModel: PharmacyModel, setOnClickListener: (PharmacyModel) -> Unit) {
        pharmacyCardBinding.apply {
            textViewAdress.text = pharmacyModel.address
            textViewPharmacyName.text = pharmacyModel.name
            textViewPharmacyPhone.text = pharmacyModel.phone

            root.setOnClickListener {
                setOnClickListener(pharmacyModel)
            }
        }

    }

}