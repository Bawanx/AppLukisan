package com.ra.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        @Suppress("DEPRECATION")
        val dataLukisan = intent.getParcelableExtra<Lukisan>("key_lukisan")

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val btShare: Button = findViewById(R.id.action_share)
        val tvDetailOrigin: TextView = findViewById(R.id.tv_detail_origin)
        val tvDetailPrice: TextView = findViewById(R.id.tv_detail_price)


        tvDetailName.text = dataLukisan?.name
        tvDetailDescription.text = dataLukisan?.description
        ivDetailPhoto.setImageResource(dataLukisan?.photo!!)
        tvDetailOrigin.text = dataLukisan.origin
        tvDetailPrice.text = dataLukisan.price


        btShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val shareText = "Cek ${dataLukisan.name} ayo, lukisan indonesia yang legend\n\n${dataLukisan.description}"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }


}