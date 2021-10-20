package com.aulia.idn.hotelapps.Detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row.view.*

class DetailAdapter(private val listener: (Hotel) -> Unit) : RecyclerView.Adapter<DetailAdapter.ViewHolder>(){
    private val listStaggered = ArrayList<Hotel>()

    fun setData(items: ArrayList<Hotel>) {
        listStaggered.clear()
        listStaggered.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        fun bind(hotel: Hotel, listener: (Hotel) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hotel.image)
                    .apply(RequestOptions().override(800))
                    .into(img_hotel_pop)
                tv_name_pop.setText(hotel.name)
                tv_address_pop.setText(hotel.location)

                itemView.setOnClickListener { listener(hotel) }
            }
        }

    }
}