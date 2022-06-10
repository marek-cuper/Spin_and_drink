package com.example.spinyourdrink

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainSpin : AppCompatActivity() {

    var pocetHracov = 0
    var cisloHracaNaRade = 0
    var listTextViewRebricek = ArrayList<TextView>()
    var listTextViewMena = ArrayList<TextView>()
    var listTextViewSkore = ArrayList<TextView>()
    var listOrigMena = ArrayList<String>()
    var listOrigSkore = ArrayList<Int>()
    var listAktMena = ArrayList<String>()
    var listAktSkore = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_spin)


        val textViewRebricek1 = findViewById<TextView>(R.id.textViewRebricek1)
        val textViewRebricek2 = findViewById<TextView>(R.id.textViewRebricek2)
        val textViewRebricek3 = findViewById<TextView>(R.id.textViewRebricek3)
        val textViewRebricek4 = findViewById<TextView>(R.id.textViewRebricek4)
        val textViewRebricek5 = findViewById<TextView>(R.id.textViewRebricek5)
        val textViewRebricek6 = findViewById<TextView>(R.id.textViewRebricek6)
        listTextViewRebricek.add(textViewRebricek1)
        listTextViewRebricek.add(textViewRebricek2)
        listTextViewRebricek.add(textViewRebricek3)
        listTextViewRebricek.add(textViewRebricek4)
        listTextViewRebricek.add(textViewRebricek5)
        listTextViewRebricek.add(textViewRebricek6)

        val textViewMeno1= findViewById<TextView>(R.id.textViewHrac1)
        val textViewMeno2 = findViewById<TextView>(R.id.textViewHrac2)
        val textViewMeno3 = findViewById<TextView>(R.id.textViewHrac3)
        val textViewMeno4 = findViewById<TextView>(R.id.textViewHrac4)
        val textViewMeno5 = findViewById<TextView>(R.id.textViewHrac5)
        val textViewMeno6 = findViewById<TextView>(R.id.textViewHrac6)
        listTextViewMena.add(textViewMeno1)
        listTextViewMena.add(textViewMeno2)
        listTextViewMena.add(textViewMeno3)
        listTextViewMena.add(textViewMeno4)
        listTextViewMena.add(textViewMeno5)
        listTextViewMena.add(textViewMeno6)

        val textViewSkore1 = findViewById<TextView>(R.id.textSkore1)
        val textViewSkore2 = findViewById<TextView>(R.id.textSkore2)
        val textViewSkore3 = findViewById<TextView>(R.id.textSkore3)
        val textViewSkore4 = findViewById<TextView>(R.id.textSkore4)
        val textViewSkore5 = findViewById<TextView>(R.id.textSkore5)
        val textViewSkore6 = findViewById<TextView>(R.id.textSkore6)
        listTextViewSkore.add(textViewSkore1)
        listTextViewSkore.add(textViewSkore2)
        listTextViewSkore.add(textViewSkore3)
        listTextViewSkore.add(textViewSkore4)
        listTextViewSkore.add(textViewSkore5)
        listTextViewSkore.add(textViewSkore6)


        val listPohlavi = intent.getStringArrayListExtra("listPohlavi")
        val listMien = intent.getStringArrayListExtra("listMien")
        if (listMien != null) {
            pocetHracov = listMien.size
            nastavRebricekZaciatok(listMien)
        }

        val tocSaButton = findViewById<Button>(R.id.tocSaButton)
        val hracNaRadeText = findViewById<TextView>(R.id.hrac_na_rade)

        hracNaRadeText.setText(listMien?.get(cisloHracaNaRade))



        tocSaButton.setOnClickListener() {
            /**
            var vyg = ArrayList<Int>()
            if(cisloHracaNaRade == 0){
                vyg.add(2)
                navys(vyg, 2)
            }
            if(cisloHracaNaRade == 1){
                vyg.add(0)
                vyg.add(1)
                vyg.add(2)
                navys(vyg, 1)
            }
            if(cisloHracaNaRade == 2){
                vyg.add(0)
                vyg.add(3)
                navys(vyg, 2)
            }
            if(cisloHracaNaRade == 3){
                vyg.add(2)
                navys(vyg, 1)
            }
            if(cisloHracaNaRade == 4){
                vyg.add(3)
                navys(vyg, 2)
            }
            **/


            cisloHracaNaRade++
            if(listMien != null){
                if(cisloHracaNaRade == pocetHracov){
                    cisloHracaNaRade = 0
                }
            }
            hracNaRadeText.setText(listMien?.get(cisloHracaNaRade))
        }
    }

    @SuppressLint("SetTextI18n")
    fun nastavRebricekZaciatok(vstupListMien: ArrayList<String>) {
        for (i in 0 until pocetHracov){
            listTextViewRebricek[i].setText((i + 1).toString() + ".")

            listTextViewMena[i].setText(vstupListMien[i])
            listOrigMena.add(vstupListMien[i])
            listAktMena.add(vstupListMien[i])

            listTextViewSkore[i].setText("0")
            listOrigSkore.add(0)
            listAktSkore.add(0)
        }
    }

    @SuppressLint("ResourceType")
    fun navys(cislaVListe: ArrayList<Int>, kolko: Int){
        for (i in 0 until pocetHracov){
            listTextViewRebricek[i].setBackgroundColor(Color.parseColor(getString(R.color.white)))
            listTextViewMena[i].setBackgroundColor(Color.parseColor(getString(R.color.white)))
            listTextViewSkore[i].setBackgroundColor(Color.parseColor(getString(R.color.white)))
        }

        for (i in 0 until cislaVListe.size){
            listOrigSkore[cislaVListe[i]] = listOrigSkore[cislaVListe[i]] + kolko
        }

        aktualizujrebricek()

        for (i in 0 until cislaVListe.size){
            val pozicia = aktualnaPozicia(cislaVListe[i])
            listTextViewRebricek[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.light_green)))
            listTextViewMena[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.light_green)))
            listTextViewSkore[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.light_green)))

        }
    }

    fun aktualnaPozicia(cisloOriginal: Int): Int{
        val meno = listOrigMena[cisloOriginal]
        for (i in 0 until pocetHracov){
            if(meno == listAktMena[i]){
                return i
            }
        }
        return 0
    }

    fun aktualizujrebricek(){
        for (i in 0 until pocetHracov){
            listAktMena.removeAt(0)
            listAktSkore.removeAt(0)
        }


        var pomocnyListMena = ArrayList<String>()
        var pomocnyListSkore = ArrayList<Int>()
        for (i in 0 until pocetHracov){
            pomocnyListMena.add(listOrigMena[i])
            pomocnyListSkore.add(listOrigSkore[i])
        }


        for (i in 0 until pocetHracov){
            var najSkore = 0
            var najPozicia = 0

            for (j in 0 until pomocnyListMena.size){
                if(najSkore < pomocnyListSkore[j]){
                    najSkore = pomocnyListSkore[j]
                    najPozicia = j
                }
            }

            listAktMena.add(pomocnyListMena[najPozicia])
            listAktSkore.add(pomocnyListSkore[najPozicia])
            pomocnyListMena.removeAt(najPozicia)
            pomocnyListSkore.removeAt(najPozicia)
        }
        for (j in 0 until pocetHracov){
            listTextViewMena[j].text = listAktMena[j]
            listTextViewSkore[j].text = listAktSkore[j].toString()
        }

    }




}

