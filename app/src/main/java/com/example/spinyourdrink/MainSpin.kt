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
        val zoznamMien = intent.getStringArrayListExtra("zoznamMien")

        hracNaRadeText.setText(zoznamMien?.get(cisloHaracNaRade))

        var mena = ""
        if(zoznamMien != null){
            for (i in 0..zoznamMien.size-1) {
                mena = mena + zoznamMien[i] + "\n"
            }
        }
        tabulkaMien.setText(mena)

        tocSaButton.setOnClickListener() {
            cisloHaracNaRade++
            if(zoznamMien != null){
                if(cisloHaracNaRade == zoznamMien.size){
                    cisloHaracNaRade = 0
                }
            }
            hracNaRadeText.setText(zoznamMien?.get(cisloHaracNaRade))
        }




    }
}