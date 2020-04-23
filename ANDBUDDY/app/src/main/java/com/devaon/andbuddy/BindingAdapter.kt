@file:Suppress("UNCHECKED_CAST")

package com.devaon.andbuddy

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devaon.andbuddy.data.datasource.model.Place
import com.devaon.andbuddy.feature.placesearch.PlaceSearchAdapter


@BindingAdapter("setPlaceData")
fun RecyclerView.setData(placeData: List<Any>?) {
    when (placeData) {
        null -> {
        }
        else -> {
            if (placeData.isNotEmpty()) {
                (this.adapter as PlaceSearchAdapter).setListData(placeData as List<Place>)
            }

        }
    }
}