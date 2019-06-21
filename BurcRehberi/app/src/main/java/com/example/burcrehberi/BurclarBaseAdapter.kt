package com.example.burcrehberi

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(context: Context, tumBurcBilgileri:ArrayList<Burc>) : BaseAdapter() {
    var tumBurclar:ArrayList<Burc>
    var context:Context

    init {
        tumBurclar=tumBurcBilgileri
        this.context=context
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var tek_satir_view=convertView
        var viewHolder:viewHolder2
        if (tek_satir_view==null){
            val inflater=LayoutInflater.from(context)
            tek_satir_view = inflater.inflate(R.layout.tek_satir,parent,false)
            viewHolder=viewHolder2(tek_satir_view)
            tek_satir_view.tag=viewHolder
        }else{
            viewHolder=tek_satir_view.tag as viewHolder2
        }

        viewHolder.burcResim.setImageResource(tumBurclar[position].burcSembol)
        viewHolder.burcAdi.text = tumBurclar[position].burcAdi
        viewHolder.burcTarih.text = tumBurclar[position].burcTarih
        return tek_satir_view
    }

    override fun getItem(position: Int): Any {
        return tumBurclar[position]
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getCount(): Int {
           return tumBurclar.size
    }

}

data class Burclar(var burcAdi:String, var burcTarih:String, var burcSembol:Int)

class viewHolder2 (tek_satir_view:View){
    var burcResim:ImageView
    var burcAdi:TextView
    var burcTarih:TextView

    init {
        this.burcResim=tek_satir_view.imgBurcSembol
        this.burcAdi=tek_satir_view.tvBurcAdi
        this.burcTarih=tek_satir_view.tvBurcTarih
    }
}