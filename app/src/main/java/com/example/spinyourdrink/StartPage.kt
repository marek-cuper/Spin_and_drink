package com.example.spinyourdrink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;

class StartPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        var button = findViewById<Button>(R.id.start_button)

        button.setOnClickListener() {
            val intent = Intent(this,NamesSettings::class.java)
            startActivity(intent)
        }

    }


}