package com.aulia.idn.hotelapps.Staggered

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_staggered.view.*

class StaggeredAdapter(private val listStaggered : ArrayList<Hotel>) : RecyclerView.Adapter<StaggeredAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staggered, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hotel: Hotel) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hotel.image)
                    .apply(RequestOptions().override(1000))
                    .into(iv_straggered_hotel)
//                iv_straggered_hotel.setImageResource(hotel.image)
                tv_straggered_name_hotel.setText(hotel.name)
                tv_straggered_address_hotel.setText(hotel.location)
                tv_straggered_desc_hotel.setText(hotel.desc)
            }

        }
    }
}