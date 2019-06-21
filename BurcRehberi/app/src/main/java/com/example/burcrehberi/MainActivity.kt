package com.example.burcrehberi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build.VERSION_CODES.O
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var tumBurcBilgileri:ArrayList<Burc>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiHazirla()

        listBurclar.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this@MainActivity,DetayActivity::class.java)
            intent.putExtra("burcPosition",position)
            intent.putExtra("tumBurcBilgileri",tumBurcBilgileri)
            startActivity(intent)
        }


        var myBaseAdapter=BurclarBaseAdapter(this,tumBurcBilgileri)
        listBurclar.adapter=myBaseAdapter

    }

    private fun veriKaynagiHazirla() {
        tumBurcBilgileri=ArrayList<Burc>(12)
        var burcAdlari= resources.getStringArray(R.array.burclar)
        var burcTarihleri= resources.getStringArray(R.array.burcTarih)
        var burcSembolleri= arrayOf(R.drawable.burc_1,R.drawable.burc_2,R.drawable.burc_3,R.drawable.burc_4,R.drawable.burc_5,
            R.drawable.burc_6,R.drawable.burc_7,R.drawable.burc_8,R.drawable.burc_9,R.drawable.burc_10,R.drawable.burc_11,R.drawable.burc_12
        )
        var burcBuyukResimler= arrayOf(R.drawable.burc_1_buyuk,R.drawable.burc_2_buyuk,R.drawable.burc_3_buyuk,R.drawable.burc_4_buyuk,R.drawable.burc_5_buyuk,R.drawable.burc_6_buyuk,R.drawable.burc_7_buyuk,R.drawable.burc_8_buyuk,R.drawable.burc_9_buyuk,R.drawable.burc_10_buyuk,R.drawable.burc_11_buyuk,R.drawable.burc_12_buyuk)
        var burcGenelOzellikleri= resources.getStringArray(R.array.burcGenelOzellikleri)

        for (i in 0..11){
            var arrayListAtanacakBurc=Burc(burcAdlari[i],burcTarihleri[i],burcSembolleri[i],burcBuyukResimler[i],burcGenelOzellikleri[i])
            tumBurcBilgileri.add(arrayListAtanacakBurc)
        }
    }
}
