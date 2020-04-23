package com.devaon.andbuddy.feature.placefavorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.devaon.andbuddy.R
import com.devaon.andbuddy.databinding.ActivityPlaceFavoriteBinding
import com.devaon.andbuddy.feature.placesearch.PlaceSearchActivity
import com.devaon.andbuddy.feature.setcomplete.SetCompleteActivity
import kotlinx.android.synthetic.main.activity_place_favorite.*

class PlaceFavoriteActivity : AppCompatActivity() {

    lateinit var binding : ActivityPlaceFavoriteBinding

    object placeObject{
        var firstFavoriteName : String = ""
        var secondFavoriteName : String = ""
        var thirdFavoriteName : String = ""
        var firstCategory = -1
        var secondCategory = -1
        var thirdCategory = -1

        var firstX : Double = 0.0
        var secondX: Double = 0.0
        var thirdX : Double = 0.0
        var firstY: Double = 0.0
        var secondY : Double = 0.0
        var thirdY: Double = 0.0

        var checkNum : Int = -1

        var placeName : String = ""
        var x : Double = 0.0
        var y : Double = 0.0


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_place_favorite)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_place_favorite)

        makeController()

        binding.placefavoriteActivity = this


    }

    private fun makeController()
    {
        selectIconController()
        selectPlaceController()
        registerController()
    }

    private fun selectIconController(){
        val placeFavoriteDialog = PlaceFavoriteIconDialogFragment()
        placeFavoriteDialog.setOnDialogDismissedListener(PlaceFavoriteDialogFragmentDismissListener)

        act_place_favorite_iv_select_one.setOnClickListener{
            placeFavoriteDialog.show(supportFragmentManager,"select_icon_first")
        }

    }

    var PlaceFavoriteDialogFragmentDismissListener = object : PlaceFavoriteIconDialogFragment.OnDialogDismissedListener {
        override fun onDialogDismissed(selectedIdx: Int) {
            when (selectedIdx) {
                0 -> act_place_favorite_iv_select_one.setImageResource(R.drawable.ic_plus)
                1 -> act_place_favorite_iv_select_one.setImageResource(R.drawable.ic_home_selected)
                2 -> act_place_favorite_iv_select_one.setImageResource(R.drawable.ic_office_selected)
                3 -> act_place_favorite_iv_select_one.setImageResource(R.drawable.ic_school_selected)
                4 -> act_place_favorite_iv_select_one.setImageResource(R.drawable.ic_other_selected)
            }
        }
    }



    private fun selectPlaceController() {
        act_place_favorite_cl_register_first.setOnClickListener {
            val intent = Intent(this@PlaceFavoriteActivity, PlaceSearchActivity::class.java)
            intent.putExtra("firstSearch", 0)
            startActivity(intent)
        }
    }


    private fun registerController(){
        act_place_favorite_tv.setOnClickListener{
            var intent = Intent(this@PlaceFavoriteActivity, SetCompleteActivity::class.java)
            startActivity(intent)
        }
        act_place_favorite_tv_skip.setOnClickListener{
            var intent = Intent(this@PlaceFavoriteActivity, SetCompleteActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
