package com.example.spinyourdrink

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainSpin : AppCompatActivity() {

    private var tocenieKolesa = false
    private var pocetHracov = 0
    private var pocetUloh = 0
    private var aktualnaUloha = -1
    private var cisloHracaNaRade = 0
    private  var kolesoAktRotacia = 0
    private var listTextViewRebricek = ArrayList<TextView>()
    private var listTextViewMena = ArrayList<TextView>()
    private var listTextViewSkore = ArrayList<TextView>()
    private var listOrigUloh = ArrayList<Int>()
    private var listOrigPohlavi = ArrayList<String>()
    private var listOrigMena = ArrayList<String>()
    private var listOrigSkore = ArrayList<Int>()
    private var listAktMena = ArrayList<String>()
    private var listAktSkore = ArrayList<Int>()
    private var ulohaPartner = ArrayList<Int>()
    private var wheeelImage: ImageView? = null
    private var vytocenaUlohaText: TextView? = null
    private var hracNaRadeText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainSpin", "onCreate called")
        setContentView(R.layout.activity_main_spin)

        wheeelImage = findViewById(R.id.imageViewKoleso)

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

        val textViewMeno1 = findViewById<TextView>(R.id.textViewHrac1)
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

        listOrigUloh = intent.getIntegerArrayListExtra("listUloh") as ArrayList<Int>
        pocetUloh = listOrigUloh.size

        when (pocetUloh) {
            10 -> {
                wheeelImage?.setImageResource(R.drawable.koleso10)
            }
            9 -> {
                wheeelImage?.setImageResource(R.drawable.koleso9)
            }
            8 -> {
                wheeelImage?.setImageResource(R.drawable.koleso8)
            }
            7 -> {
                wheeelImage?.setImageResource(R.drawable.koleso7)
            }
            6 -> {
                wheeelImage?.setImageResource(R.drawable.koleso6)
            }
            5 -> {
                wheeelImage?.setImageResource(R.drawable.koleso5)
            }
        }

        listOrigPohlavi = intent.getStringArrayListExtra("listPohlavi") as ArrayList<String>
        val listMien = intent.getStringArrayListExtra("listMien")
        if (listMien != null) {
            pocetHracov = listMien.size
            nastavRebricekZaciatok(listMien)
        }

        val tocSaButton = findViewById<Button>(R.id.tocSaButton)
        hracNaRadeText = findViewById(R.id.hrac_na_rade)
        vytocenaUlohaText = findViewById(R.id.TextViewVytocenaUloha)


        hracNaRadeText?.text = listOrigMena[cisloHracaNaRade]



        tocSaButton.setOnClickListener {
            if(!tocenieKolesa){
                tocKolesom()
                tocenieKolesa = true
            }

        }

        vytocenaUlohaText?.setOnClickListener {
            if(!tocenieKolesa){
                if(aktualnaUloha >= 0){
                    intent = Intent(this, Info::class.java).apply {
                        putExtra("cisloUlohy", aktualnaUloha)
                    }
                    startActivity(intent)

                }
            }


        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("MainSpin", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("MainSpin", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("MainSpin", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("MainSpin", "onStop called")
    }


    private fun tocKolesom(){
            var cislo = (1..360 ).random()
            kolesoAktRotacia += cislo
            kolesoAktRotacia %= 360
            val nasob = (2..4 ).random()
            cislo += (360 * nasob)
            wheeelImage?.animate()?.setDuration((500 * nasob).toLong())?.rotationBy(0F + cislo)?.withEndAction {
                val cisloVListe = kolesoAktRotacia / (360 / pocetUloh)
                aktualnaUloha = listOrigUloh[cisloVListe]
                vykonajUlohu(aktualnaUloha)

                cisloHracaNaRade++
                if (cisloHracaNaRade == pocetHracov) {
                    cisloHracaNaRade = 0
                }


                hracNaRadeText?.text = listOrigMena[cisloHracaNaRade]
                tocenieKolesa = false
            }


        }


        @SuppressLint("SetTextI18n")
        fun nastavRebricekZaciatok(vstupListMien: ArrayList<String>) {
            for (i in 0 until pocetHracov) {
                listTextViewRebricek[i].text = (i + 1).toString() + "."

                listTextViewMena[i].text = vstupListMien[i]
                listOrigMena.add(vstupListMien[i])
                listAktMena.add(vstupListMien[i])

                listTextViewSkore[i].text = "0"
                listOrigSkore.add(0)
                listAktSkore.add(0)
            }
            for(i in pocetHracov until 6){
                listTextViewRebricek[i].visibility = View.INVISIBLE
                listTextViewMena[i].visibility = View.INVISIBLE
                listTextViewSkore[i].visibility = View.INVISIBLE
            }
        }


        private fun navys(cislaVListe: ArrayList<Int>, kolko: Int) {

            for (i in 0 until cislaVListe.size) {
                listOrigSkore[cislaVListe[i]] = listOrigSkore[cislaVListe[i]] + kolko
            }

            aktualizujrebricek()

            for (i in 0 until cislaVListe.size) {
                zafarbi(cislaVListe[i], "zelena")

            }
        }

        private fun vybielRebricek(){
            for (i in 0 until pocetHracov) {
                zafarbi(i, "biela")
            }
        }

        @SuppressLint("ResourceType")
        fun zafarbi(cislo: Int, farba: String) {
            val pozicia = aktualnaPozicia(cislo)
            when (farba) {
                "zelena" -> {
                    listTextViewRebricek[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.light_green)))
                    listTextViewMena[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.light_green)))
                    listTextViewSkore[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.light_green)))
                }
                "tmavozel" -> {
                    listTextViewRebricek[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.dark_green)))
                    listTextViewMena[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.dark_green)))
                    listTextViewSkore[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.dark_green)))

                }
                "biela" -> {
                    listTextViewRebricek[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.white)))
                    listTextViewMena[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.white)))
                    listTextViewSkore[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.white)))

                }
                else -> {
                    listTextViewRebricek[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.purple_200)))
                    listTextViewMena[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.purple_200)))
                    listTextViewSkore[pozicia].setBackgroundColor(Color.parseColor(getString(R.color.purple_200)))
                }
            }

        }

        private fun aktualnaPozicia(cisloOriginal: Int): Int {
            val meno = listOrigMena[cisloOriginal]
            for (i in 0 until pocetHracov) {
                if (meno == listAktMena[i]) {
                    return i
                }
            }
            return 0
        }

        private fun aktualizujrebricek() {
            for (i in 0 until pocetHracov) {
                listAktMena.removeAt(0)
                listAktSkore.removeAt(0)
            }


            val pomocnyListMena = ArrayList<String>()
            val pomocnyListSkore = ArrayList<Int>()
            for (i in 0 until pocetHracov) {
                pomocnyListMena.add(listOrigMena[i])
                pomocnyListSkore.add(listOrigSkore[i])
            }


            for (i in 0 until pocetHracov) {
                var najSkore = 0
                var najPozicia = 0

                for (j in 0 until pomocnyListMena.size) {
                    if (najSkore < pomocnyListSkore[j]) {
                        najSkore = pomocnyListSkore[j]
                        najPozicia = j
                    }
                }

                listAktMena.add(pomocnyListMena[najPozicia])
                listAktSkore.add(pomocnyListSkore[najPozicia])
                pomocnyListMena.removeAt(najPozicia)
                pomocnyListSkore.removeAt(najPozicia)
            }
            for (j in 0 until pocetHracov) {
                listTextViewMena[j].text = listAktMena[j]
                listTextViewSkore[j].text = listAktSkore[j].toString()
            }
        }

        private fun vykonajUlohu(cisloUlohy: Int) {
            vybielRebricek()
            val ucastnici = ArrayList<Int>()
            var kolko = 0

            when (cisloUlohy) {
                0 -> {
                    vytocenaUlohaText?.text  = getString(R.string.uloha_vypi)
                    ucastnici.add(cisloHracaNaRade)
                    kolko = 1

                }
                1 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_vypi2)
                    ucastnici.add(cisloHracaNaRade)
                    kolko = 2

                }
                2 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_partner)
                    if (ulohaPartner.size > 1) {
                        ulohaPartner.removeAt(0)
                        ulohaPartner.removeAt(0)
                    }
                    ulohaPartner.add(cisloHracaNaRade)
                    var genPartner = (0 until pocetHracov).random()
                    while (genPartner == cisloHracaNaRade) {
                        genPartner = (0 until pocetHracov).random()
                    }
                    ulohaPartner.add(genPartner)

                    intent = Intent(this, Partner::class.java).apply {
                        putExtra("listHracov", listOrigMena)
                        putExtra("partneri", ulohaPartner)
                    }
                    startActivity(intent)

                    zafarbi(ulohaPartner[0], "fialova")
                    zafarbi(ulohaPartner[1], "fialova")


                }
                3 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_muzi)
                    for (i in 0 until pocetHracov){
                        if(listOrigPohlavi[i] == "muz"){
                            ucastnici.add(i)
                        }
                    }
                    kolko = 1

                }
                4 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_zeny)
                    for (i in 0 until pocetHracov){
                        if(listOrigPohlavi[i] == "zena"){
                            ucastnici.add(i)
                        }
                    }
                    kolko = 1

                }
                5 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_vsetci)
                    for (i in 0 until pocetHracov){
                        ucastnici.add(i)
                    }
                    kolko = 1

                }
                6 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_nalej)
                    ucastnici.add(cisloHracaNaRade)
                    kolko = 1

                }
                7 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_stastlivec)
                    var najmensie = listOrigSkore[0]
                    for (i in 0 until pocetHracov){
                        if(listOrigSkore[i] < najmensie){
                            najmensie = listOrigSkore[i]
                        }
                    }
                    for (i in 0 until pocetHracov){
                        if(listOrigSkore[i] == najmensie){
                            ucastnici.add(i)
                        }
                    }
                    kolko = 1

                }
                8 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_drepy)
                    zafarbi(cisloHracaNaRade, "tmavozel")

                }
                9 -> {
                    vytocenaUlohaText?.text = getString(R.string.uloha_pauza)
                    zafarbi(cisloHracaNaRade, "tmavozel")
                }
            }

            if (kolko != 0){
                if (ulohaPartner.size != 0) {
                    if (ucastnici.contains(ulohaPartner[0])) {
                        if (!ucastnici.contains(ulohaPartner[1])) {
                            ucastnici.add(ulohaPartner[1])
                            navys(ucastnici, kolko)
                            zafarbi(ulohaPartner[1], "fialova")
                        } else {
                            navys(ucastnici, kolko)
                        }
                    } else if (ucastnici.contains(ulohaPartner[1])) {
                        ucastnici.add(ulohaPartner[0])
                        navys(ucastnici, kolko)
                        zafarbi(ulohaPartner[0], "fialova")
                    } else{
                        navys(ucastnici, kolko)
                    }
                } else{
                    navys(ucastnici, kolko)
                }
            }


        }




}

