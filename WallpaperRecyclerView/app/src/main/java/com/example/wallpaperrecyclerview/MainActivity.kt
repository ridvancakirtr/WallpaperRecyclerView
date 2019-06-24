package com.example.wallpaperrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var wallpaper=ArrayList<wallpaper>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adaptor=wallpaperAdaptor(addArray())
        recyclerview.adapter=adaptor

        var menuLinearViewVertical=LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
        recyclerview.layoutManager=menuLinearViewVertical
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id=item?.itemId
        when(id){
            R.id.menuLinearViewHorizontal->{
                var menuLinearViewHorizontal=LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL,false)
                recyclerview.layoutManager=menuLinearViewHorizontal
            }
            R.id.menuLinearViewVertical->{
                var menuLinearViewVertical=LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
                recyclerview.layoutManager=menuLinearViewVertical
            }
            R.id.menuGrid->{
                var menuGrid=GridLayoutManager(this@MainActivity,2)
                recyclerview.layoutManager=menuGrid
            }
            R.id.staggaredHorizental->{
                var staggaredHorizental=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
                recyclerview.layoutManager=staggaredHorizental
            }
            R.id.staggaredVertical->{
                var staggaredVertical=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                recyclerview.layoutManager=staggaredVertical
            }
        }
        return true
    }
    fun addArray():ArrayList<wallpaper>{
        var allImage= arrayOf(
            R.drawable.abc_1,
            R.drawable.abc_2,
            R.drawable.abc_3,
            R.drawable.abc_4,
            R.drawable.abc_5,
            R.drawable.abc_6,
            R.drawable.abc_7
        )

        for (i in 0 until allImage.size){
            var addWallpaper=wallpaper("Title $i", "Description $i",allImage[i])
            wallpaper.add(addWallpaper)
        }

        return wallpaper
    }
}
