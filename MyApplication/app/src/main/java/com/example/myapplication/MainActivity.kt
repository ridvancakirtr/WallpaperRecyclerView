package com.example.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraintlayout)

            Toast.makeText(this@MainActivity,"YASİN KARAZONOVİÇ",Toast.LENGTH_LONG)
    }
}
