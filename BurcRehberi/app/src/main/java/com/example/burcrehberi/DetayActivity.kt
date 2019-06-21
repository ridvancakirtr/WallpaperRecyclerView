package com.example.burcrehberi

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*
import java.util.ArrayList

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var position=intent.extras.get("burcPosition") as Int
        var tumBurcBilgileri=intent.extras.get("tumBurcBilgileri") as ArrayList<Burc>
        Toast.makeText(this,"Deger " + position + "Tum Burc Sayısı : " + tumBurcBilgileri.size,Toast.LENGTH_SHORT).show()
        tvBurcOzellikleri.text = tumBurcBilgileri[position].burcAciklama
        header.setImageResource(tumBurcBilgileri[position].burcBuyukResim)

        collapsing_toolbar.title=tumBurcBilgileri[position].burcAdi

        var bitmap=BitmapFactory.decodeResource(resources,tumBurcBilgileri[position].burcBuyukResim)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(p0: Palette?) {
                var color= p0?.getVibrantColor(R.attr.color)
                collapsing_toolbar.setContentScrimColor(color!!)
                window.statusBarColor=color
            }

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
