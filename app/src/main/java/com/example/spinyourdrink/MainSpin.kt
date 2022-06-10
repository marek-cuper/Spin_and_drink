package com.example.spinyourdrink

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainSpin : AppCompatActivity() {

    var cisloHaracNaRade = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_spin)

        var tocSaButton = findViewById<Button>(R.id.tocSaButton)
        var tabulkaMien = findViewById<TextView>(R.id.TextView_Tabulka_Mien)
        var hracNaRadeText = findViewById<TextView>(R.id.hrac_na_rade)
        val listMien = intent.getStringArrayListExtra("listMien")

        hracNaRadeText.setText(listMien?.get(cisloHaracNaRade))

        var mena = ""
        if(listMien != null){
            for (i in 0..listMien.size-1) {
                mena = mena + listMien[i] + "\n"
            }
        }
        tabulkaMien.setText(mena)

        tocSaButton.setOnClickListener() {
            cisloHaracNaRade++
            if(listMien != null){
                if(cisloHaracNaRade == listMien.size){
                    cisloHaracNaRade = 0
                }
            }
            hracNaRadeText.setText(listMien?.get(cisloHaracNaRade))
        }




    }
}