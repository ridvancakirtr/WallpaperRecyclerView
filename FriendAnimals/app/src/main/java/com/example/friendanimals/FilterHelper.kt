package com.example.friendanimals

import android.widget.Filter

open class FilterHelper(animals:ArrayList<AnimalData>,adaptor:Adaptor) : Filter(){
    var AllAnimals=animals
    var newAdaptor=adaptor
    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var sonuc=FilterResults()

        if(constraint!=null && constraint.isNotEmpty()){
            var aranilanaAd=constraint.toString().toLowerCase()
            var eslesenler=ArrayList<AnimalData>()
            for (anim in AllAnimals){
                var adi=anim.animalName
                if (adi.contains(aranilanaAd)){
                    eslesenler.add(anim)
                }
            }

            sonuc.values=eslesenler
            sonuc.count=eslesenler.size

        }else{
            sonuc.values=AllAnimals
            sonuc.count=AllAnimals.size
        }

        return sonuc

    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        newAdaptor.setFilter(results?.values as ArrayList<AnimalData>)
        newAdaptor.notifyDataSetChanged()
    }

}