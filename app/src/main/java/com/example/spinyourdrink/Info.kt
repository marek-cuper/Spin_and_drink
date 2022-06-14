package com.example.spinyourdrink

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class Info : AppCompatActivity() {

    private var cisloUlohy = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Info", "onCreate called")
        setContentView(R.layout.activity_info)

        cisloUlohy = intent.getIntExtra("cisloUlohy", 0)
        val textViewUloha = findViewById<TextView>(R.id.textViewAktualnaUloha)
        val textViewPopis = findViewById<TextView>(R.id.textViewPopisUlohy)

        when (cisloUlohy) {
            0 -> {
                textViewUloha?.text = getString(R.string.uloha_vypi)
                textViewPopis?.text = getString(R.string.popis_vypi)
            }
            1 -> {
                textViewUloha?.text = getString(R.string.uloha_vypi2)
                textViewPopis?.text = getString(R.string.popis_vypi2)
            }
            2 -> {
                textViewUloha?.text = getString(R.string.uloha_partner)
                textViewPopis?.text = getString(R.string.popis_partner)
            }
            3 -> {
                textViewUloha?.text = getString(R.string.uloha_muzi)
                textViewPopis?.text = getString(R.string.popis_muzi)
            }
            4 -> {
                textViewUloha?.text = getString(R.string.uloha_zeny)
                textViewPopis?.text = getString(R.string.popis_zeny)
            }
            5 -> {
                textViewUloha?.text = getString(R.string.uloha_vsetci)
                textViewPopis?.text = getString(R.string.popis_vsetci)
            }
            6 -> {
                textViewUloha?.text = getString(R.string.uloha_nalej)
                textViewPopis?.text = getString(R.string.popis_nalej)
            }
            7 -> {
                textViewUloha?.text = getString(R.string.uloha_stastlivec)
                textViewPopis?.text = getString(R.string.popis_stastlivec)
            }
            8 -> {
                textViewUloha?.text = getString(R.string.uloha_drepy)
                textViewPopis?.text = getString(R.string.popis_drepy)
            }
            9 -> {
                textViewUloha?.text = getString(R.string.uloha_pauza)
                textViewPopis?.text = getString(R.string.popis_pauza)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Info", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("Info", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("Info", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("Info", "onStop called")
    }
}