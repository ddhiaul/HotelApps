package com.aulia.idn.hotelapps.List

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.R
import com.bumptech.glide.Glide

class HotelListAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal  var hotels = arrayListOf<Hotel>()
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_list,p2,false)
        }
        val viewHolder = ViewHolder(view as View)
        val hotel = getItem(p0) as Hotel
        viewHolder.bind(hotel)
        return view
    }

    override fun getItem(p0: Int): Any = hotels[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getCount(): Int = hotels.size

    private inner class ViewHolder internal constructor(view: View) {
        private val tvName : TextView = view.findViewById(R.id.tv_name)
        private val tvLocation : TextView = view.findViewById(R.id.tv_location)
        private val imgHotel : ImageView = view.findViewById(R.id.img_hotel)

        internal fun bind(modelActivity: Hotel){
            tvName.setText(modelActivity.name)
            tvLocation.text = modelActivity.location
            Glide.with(context!!).load(modelActivity.image).override(500).into(imgHotel)
        }
    }
}