package com.aulia.idn.hotelapps.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aulia.idn.hotelapps.Hotel
import com.aulia.idn.hotelapps.MainActivity
import com.aulia.idn.hotelapps.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val KEY_POP_HOTEL = "key_pop_hotel"
    }

    private var hotel : Hotel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        iv_back_to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        hotel = intent.getParcelableExtra(KEY_POP_HOTEL)

        supportActionBar?.hide()

        tv_detail_name_hotel.setText(hotel?.name)
        tv_detail_location_hotel.setText(hotel?.location)
        tv_detail_desc_hotel.setText(hotel?.desc)
        tv_price.setText(hotel?.price)
        tv_detail_title_hotel.setText(hotel?.name)
//        iv_detail_hotel.setImageResource(hotel?.image!!)
        Glide.with(this).load(hotel?.image).apply(RequestOptions().override(500)).into(iv_detail_hotel)
    }
}
