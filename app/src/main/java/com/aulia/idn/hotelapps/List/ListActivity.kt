package com.aulia.idn.hotelapps.List

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private lateinit var adapter : HotelListAdapter
    private var hotels = arrayListOf<Hotel>()
    private lateinit var name : Array<String>
    private lateinit var location : Array<String>
    private lateinit var desc : ArrayList<String>
    private lateinit var price : ArrayList<String>
    private lateinit var image : TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        supportActionBar?.hide()

        adapter = HotelListAdapter(this)

        lv_hotel.adapter = adapter
        attachData()
        loadData()
    }
    private fun loadData() {
        for (p0 in name.indices) {
            val hotel = Hotel(
                name[p0],
                location[p0],
                desc[p0],
                price[p0],
                image.getResourceId(p0, -1)
            )
            hotels.add(hotel)
        }
        adapter.hotels = hotels
    }

    private fun attachData() {
        name = resources.getStringArray(R.array.name)
        location = resources.getStringArray(R.array.location)
        image = resources.obtainTypedArray(R.array.image)
    }
}
