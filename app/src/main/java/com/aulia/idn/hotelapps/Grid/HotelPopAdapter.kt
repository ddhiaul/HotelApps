package com.aulia.idn.hotelapps.Grid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row.view.*

class HotelPopAdapter (private val listHotelPop : ArrayList<Hotel>) : RecyclerView.Adapter<HotelPopAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listHotelPop.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHotelPop[position])
    }

    class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
        fun bind(hotel: Hotel) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(hotel.image)
                    .apply(RequestOptions().override(500))
                    .into(img_hotel_pop)
                tv_name_pop.setText(hotel.name)
                tv_address_pop.setText(hotel.location)
            }
        }

    }
}