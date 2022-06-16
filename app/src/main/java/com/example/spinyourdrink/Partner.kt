package com.example.spinyourdrink

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Marek Cuper
 * Obrazovka ktorá slúži na grafické vylosovanie picieho partnera pre daného hráča.
 * */
class Partner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Partner", "onCreate called")
        setContentView(R.layout.activity_partner)

        val hraci = intent.getStringArrayListExtra("listHracov")
        val partneri = intent.getIntegerArrayListExtra("partneri")
        val wheeelImage = findViewById<ImageView>(R.id.imageViewPartnerKoleso)
        val textPartne1 = findViewById<TextView>(R.id.textPartner1)
        val textPartne2 = findViewById<TextView>(R.id.textPartner2)

        if(hraci != null){
            textPartne1.text = hraci[partneri?.get(0)!!]
            val partnerCislo = partneri[1]

            when {
                hraci.size - 1 == 5 -> {
                    wheeelImage?.setImageResource(R.drawable.koleso5)
                }
                hraci.size - 1 == 4 -> {
                    wheeelImage?.setImageResource(R.drawable.koleso4)
                }
                hraci.size - 1 == 3 -> {
                    wheeelImage?.setImageResource(R.drawable.koleso3)
                }
                hraci.size - 1 == 2 -> {
                    wheeelImage?.setImageResource(R.drawable.koleso2)
                }
            }

            val cast = 360 / (hraci.size - 1)
            var cislo = (1 until cast ).random()
            hraci.removeAt(partneri[0] ?: 0)
            cislo += (partnerCislo?.times(cast)!!)
            val nasob = (2..4 ).random()
            cislo += (360 * nasob)
            wheeelImage?.animate()?.setDuration((500 * nasob).toLong())?.rotationBy(0F + cislo)?.withEndAction {
                textPartne2.text = hraci[partneri[1]!!]
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Partner", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("Partner", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("Partner", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("Partner", "onStop called")
    }


}