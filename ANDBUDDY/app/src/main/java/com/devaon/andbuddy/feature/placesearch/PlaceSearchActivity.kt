package com.devaon.andbuddy.feature.placesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.devaon.andbuddy.R
import com.devaon.andbuddy.databinding.ActivityPlaceSearchBinding

class PlaceSearchActivity : AppCompatActivity() {

    lateinit var placeSearchAdapter: PlaceSearchAdapter

    val vm : PlaceSearchViewModel = PlaceSearchViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityPlaceSearchBinding
            = DataBindingUtil.setContentView(this, R.layout.activity_place_search)

        binding.vm = vm
        binding.lifecycleOwner = this

        placeSearchAdapter = PlaceSearchAdapter()
        binding.actPlaceSearchRv.adapter = placeSearchAdapter


        binding.btnSearch.setOnClickListener{
            vm.getAddress(binding.actPlaceSearchEtSearch.text.toString())
        }
    }

}