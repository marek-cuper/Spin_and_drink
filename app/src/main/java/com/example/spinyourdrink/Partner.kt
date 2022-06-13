package com.example.spinyourdrink

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
            }else if(hraci.size - 1 == 4){
                wheeelImage?.setImageResource(R.drawable.koleso4)
            }else if(hraci.size - 1 == 3){
                wheeelImage?.setImageResource(R.drawable.koleso3)
            }else if(hraci.size - 1 == 2){
                wheeelImage?.setImageResource(R.drawable.koleso2)
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