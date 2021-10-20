package com.aulia.idn.hotelapps.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.aulia.idn.hotelapps.Detail.DetailActivity
import com.aulia.idn.hotelapps.Detail.DetailAdapter
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.List.ListActivity
import com.aulia.idn.hotelapps.Grid.HotelPopAdapter
import com.aulia.idn.hotelapps.R
import com.aulia.idn.hotelapps.Staggered.StaggeredActivity
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    private lateinit var detailHotelAdapter : DetailAdapter
//    private val hotelList = ArrayList<Hotel>()

    companion object {
        fun defaultFragment() : HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    val imgcontentSlider = intArrayOf(
        R.drawable.promo1,
        R.drawable.promo2,
        R.drawable.promo3,
        R.drawable.promo4
    )

    val imgContentListener : ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(imgcontentSlider[position])
//            Glide.with(context!!).load(imgcontentSlider).placeholder(R.drawable.promo1).into(imageView)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imgContentListener)
        carouselView.setPageCount(imgcontentSlider.count())

//        rv_hotel.setHasFixedSize(true)
//        hotelList.addAll(getListHotel())
        showRecycleList()

        tv_see.setOnClickListener {
            val intent = Intent(context, StaggeredActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListHotel(): ArrayList<Hotel> {
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

    private fun showRecycleList() {
        detailHotelAdapter = DetailAdapter { showSelected(it) }
        detailHotelAdapter.notifyDataSetChanged()
        detailHotelAdapter.setData(getListHotel())
        rv_hotel.setHasFixedSize(true)
        rv_hotel.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)
//        val adapter = HotelPopAdapter(hotelList)
        rv_hotel.adapter = detailHotelAdapter
    }

    private fun showSelected(it: Hotel) {
        val page = Intent(context, DetailActivity::class.java)
        page.putExtra(DetailActivity.KEY_POP_HOTEL, it)
        startActivity(page)
    }

}
