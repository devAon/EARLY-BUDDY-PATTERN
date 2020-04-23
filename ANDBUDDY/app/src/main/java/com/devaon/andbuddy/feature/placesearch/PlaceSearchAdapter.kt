package com.devaon.andbuddy.feature.placesearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devaon.andbuddy.data.datasource.model.Place
import com.devaon.andbuddy.databinding.ItemAddressBinding


class PlaceSearchAdapter() : RecyclerView.Adapter<PlaceSearchAdapter.PlaceSearchViewHolder>() {
    val newPlaceList = ArrayList<Place>()

    fun setListData(placeList : List<Place>){
        with(newPlaceList){
            clear()
            addAll(placeList)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceSearchViewHolder {
        val binding : ItemAddressBinding
                = ItemAddressBinding.inflate(LayoutInflater.from(parent.context),parent, false);
        return PlaceSearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newPlaceList.size
    }

    override fun onBindViewHolder(holder: PlaceSearchViewHolder, position: Int) {
        holder.bind(newPlaceList[position])
    }

    class PlaceSearchViewHolder(val binding: ItemAddressBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(data : Place){
            binding.place = data;
        }
    }
}

