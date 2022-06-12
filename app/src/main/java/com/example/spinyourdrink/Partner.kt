package com.example.spinyourdrink

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.spinyourdrink.databinding.ActivityPartnerBinding

class Partner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partner)

        val hraci = intent.getStringArrayListExtra("listHracov")
        val partneri = intent.getIntegerArrayListExtra("partneri")
        var wheeelImage = findViewById<ImageView>(R.id.imageViewPartnerKoleso)
        var textPartne1 = findViewById<TextView>(R.id.textPartner1)
        var textPartne2 = findViewById<TextView>(R.id.textPartner2)

        if(hraci != null){
            textPartne1.text = hraci?.get(partneri?.get(0)!!)
            val partnerCislo = partneri?.get(1)

            if(hraci.size - 1 == 5){
                wheeelImage?.setImageResource(R.drawable.koleso5)
            }

            var cast = 360 / (hraci.size - 1)
            var cislo = (1 until cast ).random()
            hraci.removeAt(partneri?.get(0) ?: 0)
            cislo += (partnerCislo?.times(cast)!!)
            val nasob = (2..4 ).random()
            cislo += (360 * nasob)
            wheeelImage?.animate()?.setDuration((500 * nasob).toLong())?.rotationBy(0F + cislo)?.withEndAction {
                textPartne2.text = hraci?.get(partneri?.get(1)!!)
            }





        }




    }


}