package com.example.exfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val menuList = intent.getStringArrayListExtra("menuList")

        var tvList : TextView = findViewById(R.id.tvList)

        Log.d("meneList", "${menuList}")

    }
}