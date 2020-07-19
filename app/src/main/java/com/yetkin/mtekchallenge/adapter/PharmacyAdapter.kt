package com.yetkin.mtekchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yetkin.mtekchallenge.data.model.PharmacyModel
import com.yetkin.mtekchallenge.databinding.PharmacyCardBinding


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class PharmacyAdapter(
    private val setOnclickListener: (PharmacyModel) -> Unit
) : ListAdapter<PharmacyModel, PharmacyHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyHolder {

        val pharmacyCardBinding = PharmacyCardBinding.inflate(LayoutInflater.from(parent.context))
        return PharmacyHolder(pharmacyCardBinding)
    }

    override fun onBindViewHolder(holder: PharmacyHolder, position: Int) {
        holder.bind(getItem(position), setOnclickListener)
    }

    class DiffCallBack : DiffUtil.ItemCallback<PharmacyModel>() {
        override fun areItemsTheSame(oldItem: PharmacyModel, newItem: PharmacyModel): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: PharmacyModel, newItem: PharmacyModel): Boolean =
            oldItem == newItem

    }
}