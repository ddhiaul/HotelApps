package com.aulia.idn.hotelapps.Staggered

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aulia.idn.hotelapps.Detail.DetailActivity
import com.aulia.idn.hotelapps.Detail.DetailAdapter
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.MainActivity
import com.aulia.idn.hotelapps.R
import kotlinx.android.synthetic.main.activity_staggered.*

class StaggeredActivity : AppCompatActivity() {
    private lateinit var detailHotelAdapter : DetailAdapter
    private val listHotel = ArrayList<Hotel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered)
        iv_to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        rv_staggered.setHasFixedSize(true)
        listHotel.addAll(getStaggeredHotel())
        showRecyclerGrid()

        supportActionBar?.hide()
    }

    private fun getStaggeredHotel(): ArrayList<Hotel> {
        val name = resources.getStringArray(R.array.name)
        val location = resources.getStringArray(R.array.location)
        val desc = resources.getStringArray(R.array.desc)
        val price = resources.getStringArray(R.array.price)
        val image = resources.obtainTypedArray(R.array.image)

        val listHotel = ArrayList<Hotel>()

        for (position in name.indices){
            val hotel = Hotel(
                name[position],
                location[position],
                desc[position],
                price[position],
                image.getResourceId(position, -1)
            )
            listHotel.add(hotel)
        }
        return listHotel
    }

    private fun showRecyclerGrid() {
        detailHotelAdapter = DetailAdapter { showSelected(it) }
        detailHotelAdapter.notifyDataSetChanged()
        detailHotelAdapter.setData(getStaggeredHotel())
        val layoutManagerStaggered = StaggeredGridLayoutManager(2,
            GridLayoutManager. VERTICAL)
        rv_staggered.layoutManager = layoutManagerStaggered
        rv_staggered.adapter = StaggeredAdapter(listHotel)
        rv_staggered.setHasFixedSize(true)
        rv_staggered.adapter = detailHotelAdapter
    }

    private fun showSelected(it: Hotel) {
        val page = Intent(this, DetailActivity::class.java)
        page.putExtra(DetailActivity.KEY_POP_HOTEL, it)
        startActivity(page)
    }
}
