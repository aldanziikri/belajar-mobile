package com.example.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    fun hitung(panjang:Long, lebar:Long, tinggi:Long): Long{
        return panjang * lebar * tinggi
    }

    @SuppressLint("MissingInflatedId")//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lebar: EditText = findViewById(R.id.lebar)
        val tinggi: EditText = findViewById(R.id.tinggi)
        val panjang: EditText = findViewById<EditText?>(R.id.panjang)
        val btn_hitung: Button = findViewById(R.id.hitung_btn)
        val result: TextView = findViewById(R.id.result)

        btn_hitung.setOnClickListener({
            val hasil = hitung(panjang.text.toString().toLong(), lebar.text.toString().toLong(), tinggi.text.toString().toLong())
            result.text = hasil.toString()
        })

    }
}