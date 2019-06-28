package com.example.friendanimals

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Toast
import android.widget.Filterable
import kotlinx.android.synthetic.main.oneline.view.*
import java.io.FilterReader

class Adaptor(animalData : ArrayList<AnimalData>):RecyclerView.Adapter<Adaptor.AdaptorViewHolder>(),Filterable{
    var animal= animalData
    var myFilter: FilterHelper =FilterHelper(animalData,this)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptorViewHolder {
        var inflater=LayoutInflater.from(p0.context)
        var oneline=inflater.inflate(R.layout.oneline,p0,false)
        return AdaptorViewHolder(oneline)
    }

    override fun getItemCount(): Int {
        return animal.size
    }

    override fun onBindViewHolder(p0: AdaptorViewHolder, p1: Int) {
        var anlik=animal[p1]
        p0.setData(anlik)
    }

    fun setFilter(arrayList: ArrayList<AnimalData>) {
        animal=arrayList
    }


    class AdaptorViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var onelineItem=itemView
        var image=onelineItem.image
        var title=onelineItem.title

        fun setData(animal:AnimalData) {
            this.image.setImageResource(animal.animalImage)
            this.title.text=animal.animalName

            onelineItem.setOnClickListener {
                Toast.makeText(onelineItem.context, "Tıklanılan Öğe: ${title.text}",Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun getFilter(): Filter {
        return myFilter  //adaptor sınıfında oluşturulan filter tipindeki dosyayı döndürür
    }


    /*
    fun setFilter(aranilan:ArrayList<AnimalData>){
        animal=ArrayList<AnimalData>()
        animal.addAll(aranilan)
        notifyDataSetChanged()

    }
    */
}