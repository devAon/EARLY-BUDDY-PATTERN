package com.devaon.andbuddy.feature.placefavorite

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.devaon.andbuddy.R


class PlaceFavoriteIconDialogFragment : DialogFragment() {

    lateinit var home : ImageView
    lateinit var office : ImageView
    lateinit var school : ImageView
    lateinit var  other : ImageView
    lateinit var  cancel : ImageView

    //icon idex
    // default : 0, home : 1 , office : 2, school : 3, other : 4
    var selectedIdx  = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_place_favorite_icon_dialog, container, false)

        home = view.findViewById(R.id.dialog_fragment_place_favorite_iv_home)
        office = view.findViewById(R.id.dialog_fragment_place_favorite_iv_office)
        school = view.findViewById(R.id.dialog_fragment_place_favorite_iv_school)
        other = view.findViewById(R.id.dialog_fragment_place_favorite_iv_other)
        cancel = view.findViewById(R.id.dialog_fragment_place_favorite_iv_cancel)

        selectIcon()

        var btn = view.findViewById<TextView>(R.id.dialog_fragment_place_favorite_tv_ok)
        btn.setOnClickListener{
            dismiss()
        }
        cancel.setOnClickListener{
            dismiss()
        }

        return view
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }


    interface OnDialogDismissedListener{
        fun onDialogDismissed(selectedId : Int)
    }

    lateinit var listener : OnDialogDismissedListener

    fun setOnDialogDismissedListener(listener : OnDialogDismissedListener){
        this.listener = listener
    }

    override fun dismiss() {
        listener.onDialogDismissed(selectedIdx)
        super.dismiss()
    }

    fun selectIcon(){
        home.setOnClickListener {
            Log.d("test", "home oncolick")
            if(!home.isSelected){
                Log.d("test", "home is selected")
                home.setSelected(true)
                office.setSelected(false)
                school.setSelected(false)
                other.setSelected(false)
            }
            selectedIdx = 1
        }

        office.setOnClickListener {
            if(!office.isSelected){
                Log.d("test", "office is selected")
                office.setSelected(true)
                home.setSelected(false)
                school.setSelected(false)
                other.setSelected(false)
            }
            selectedIdx = 2
        }

        school.setOnClickListener {
            if(!school.isSelected){
                Log.d("test", "school is selected")
                school.setSelected(true)
                office.setSelected(false)
                home.setSelected(false)
                other.setSelected(false)
            }
            selectedIdx = 3
        }

        other.setOnClickListener {
            if(!other.isSelected){
                Log.d("test", "other is selected")
                other.setSelected(true)
                office.setSelected(false)
                school.setSelected(false)
                home.setSelected(false)
            }
            selectedIdx = 4
        }


    }

    /*private fun selectIcon(){
        home.setOnClickListener{
            //if(!home.isSelected)
        }

        office.setOnClickListener{

        }

        school.setOnClickListener{

        }

        other.setOnClickListener{

        }

    }*/



}

