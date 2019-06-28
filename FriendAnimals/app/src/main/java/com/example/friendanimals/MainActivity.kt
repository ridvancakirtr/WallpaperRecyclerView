package com.example.friendanimals

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()/*,SearchView.OnQueryTextListener*/{

    lateinit var myAdaptor : Adaptor
    var animalData=ArrayList<AnimalData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veriKaynagiHazirla()
        myAdaptor=Adaptor(animalData)
        recyclerView.adapter=myAdaptor

        var menuLinearViewVertical= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager=menuLinearViewVertical

        searchView.setOnQueryTextListener(object : android.support.v7.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdaptor.filter.filter(newText)
                return false
            }

        })

    }
    /*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.searchmenu,menu)
        var aramaItem=menu?.findItem(R.id.app_bar_search)
        var searchView=aramaItem?.actionView as android.widget.SearchView
        searchView.setOnQueryTextListener(this)



        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        var girilenVeri=newText?.toLowerCase()
        var arananlar=ArrayList<AnimalData>()
        for (data in animalData){
            var animalName=data.animalName
            if (animalName.contains(girilenVeri.toString())){
                arananlar.add(data)
            }
        }
        myAdaptor.setFilter(arananlar)
        return true
    }
    */
    private fun veriKaynagiHazirla() {

        var animalImage= arrayOf(R.drawable.burc_1_buyuk,R.drawable.burc_2_buyuk,R.drawable.burc_3_buyuk,R.drawable.burc_4_buyuk,R.drawable.burc_5_buyuk,R.drawable.burc_6_buyuk,R.drawable.burc_7_buyuk,R.drawable.burc_8_buyuk,R.drawable.burc_9_buyuk,R.drawable.burc_10_buyuk,R.drawable.burc_11_buyuk,R.drawable.burc_12_buyuk)
        for (i in 0..11){
            var addAnimal=AnimalData("İsim $i",animalImage[i])
            animalData.add(addAnimal)
        }
    }
}
