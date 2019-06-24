package com.example.wallpaperrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.oneline.view.*

class wallpaperAdaptor(var wallpaper:ArrayList<wallpaper>):RecyclerView.Adapter<wallpaperAdaptor.wallpaperViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wallpaperViewHolder {
        var inflater=LayoutInflater.from(parent.context)
        var oneline=inflater.inflate(R.layout.oneline,parent,false)
        return wallpaperViewHolder(oneline)
    }

    override fun getItemCount(): Int {
       return this.wallpaper.size
    }

    override fun onBindViewHolder(holder: wallpaperViewHolder, position: Int) {
        var instantData=wallpaper[position]
        holder.setData(instantData,position)

    }

    inner class wallpaperViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var itemView=itemView as CardView
        var title=itemView.tvTitle
        var description=itemView.tvDescription
        var img=itemView.img_row

        var btnDelete=itemView.img_row_delete
        var btnCopy=itemView.img_row_add

        init {

        }

        fun setData(instantData:wallpaper,position: Int) {
            title.text=instantData.title
            description.text=instantData.description
            img.setImageResource(instantData.image)

            btnDelete.setOnClickListener {
                wallpaper.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,wallpaper.size)
                //Arraylisti veriler silindiksen snra veya eklendikden snra günceller
                Log.e("RIDVAN",""+ position + "SİL TIKLANDI")
            }

            btnCopy.setOnClickListener {
                wallpaper.add(position,instantData)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,wallpaper.size)
                //Arraylisti veriler silindiksen snra veya eklendikden snra günceller
                Log.e("RIDVAN",""+ position + "KOPYALA TIKLANDI")
            }
        }
    }
}