package com.example.exfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv1 : TextView = findViewById(R.id.tv1)
        val btn1 : TextView = findViewById(R.id.btn1)
        var num : Int = 0
        var name: String?

        //var menuList = MenuItem().menuList
        var menuList = mutableListOf<String>()

        var db:FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("menu")
            .get()
            .addOnSuccessListener { result->
                for (document in result) {
                    //Log.d("firebase", "${document.id} => ${document.data}")
                    Log.d("firebase", "${document.data.get("menu")}")
                    menuList.add(document.data.get("menu").toString())
                }
            }

        btn1.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putStringArrayListExtra("menuList", ArrayList(menuList))
            startActivity(intent)
            //Log.d("meneList", "${menuList}")
        }
    }
}