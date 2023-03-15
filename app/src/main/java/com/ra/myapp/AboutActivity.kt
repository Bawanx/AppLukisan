package com.ra.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.hdodenhof.circleimageview.CircleImageView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val waButton: CircleImageView = findViewById(R.id.iv_wa)
        val teleButton: CircleImageView = findViewById(R.id.iv_telegram)

        waButton.setOnClickListener {
            val toNumber = "whatsapp:+6295173117372"
            val message = "Halo! Boleh kenalan gak?"

            val uri = Uri.parse("https://api.whatsapp.com/send?phone=$toNumber&text=$message")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        teleButton.setOnClickListener {
            val toNumber = "6281226780060"
            val message = ""

            val uri = Uri.parse("tg://msg?to=$toNumber&text=$message")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("org.telegram.messenger")
            startActivity(intent)
        }
    }
}