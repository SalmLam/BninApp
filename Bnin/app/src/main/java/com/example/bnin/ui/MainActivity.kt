package com.example.bnin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bnin.R

    /*
    * Class Name  : MainActivity
    * Description : Main an unique activity containing all the other fragments
    * */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}