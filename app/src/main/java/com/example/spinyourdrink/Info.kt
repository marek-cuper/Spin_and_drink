package com.example.spinyourdrink

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class Info : AppCompatActivity() {

    var cisloUlohy = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        cisloUlohy = intent.getIntExtra("cisloUlohy", 0)
        val textViewUloha = findViewById<TextView>(R.id.textViewAktualnaUloha)
        val textViewPopis = findViewById<TextView>(R.id.textViewPopisUlohy)

        if(cisloUlohy == 0){
            textViewUloha?.text = getString(R.string.uloha_vypi)
            textViewPopis?.text = "Vypije shot ten kto bol na rade s točením kolesa, prípadne ešte ten kto je jeho parťák"
        } else if(cisloUlohy == 1){
            textViewUloha?.text = getString(R.string.uloha_vypi2)
            textViewPopis?.text = "Vypije dva shoty ten kto bol na rade s točením kolesa, prípadne ešte ten kto je jeho parťák"
        } else if(cisloUlohy == 2){
            textViewUloha?.text = getString(R.string.uloha_partner)
            textViewPopis?.text = "Hráč ktorý bol na rade s točením dostane nahodného hráča za parťáka, parťáci pijú vždy spolu." +
                    "Ak pije prvý, pije aj druhý. Parťákmi ostávate dokým sa nevyžrebuje ďalšia dvojica"
        } else if(cisloUlohy == 3){
            textViewUloha?.text = getString(R.string.uloha_muzi)
            textViewPopis?.text = "Pijú shot všetci muži, prípadne aj parťáčka"
        } else if(cisloUlohy == 4){
            textViewUloha?.text = getString(R.string.uloha_zeny)
            textViewPopis?.text = "Pijú shot všetky ženy, prípadne aj parťák"
        } else if(cisloUlohy == 5){
            textViewUloha?.text = getString(R.string.uloha_vsetci)
            textViewPopis?.text = "Všetci pijú shot"
        } else if(cisloUlohy == 6){
            textViewUloha?.text = getString(R.string.uloha_nalej)
            textViewPopis?.text = "Hráčovi ktorý bol na rade s točením kolesa bude naliaty shot do úst od hráča po jeho pravici," +
                    " prípadne hráč naleje aj jeho parťákovi"
        } else if(cisloUlohy == 7){
            textViewUloha?.text = getString(R.string.uloha_stastlivec)
            textViewPopis?.text = "Šťastlivci ktorí majú najmenej shotov v sebe vypijú shot, prípadne ešte jeho parťák"
        } else if(cisloUlohy == 8){
            textViewUloha?.text = getString(R.string.uloha_drepy)
            textViewPopis?.text = "Hráč ktorý bol na rade s točením kolesa spraví 10 drepov"
        } else if(cisloUlohy == 9){
            textViewUloha?.text = getString(R.string.uloha_pauza)
            textViewPopis?.text = "Hráč ktorý bol na rade s točením kolesa nespraví nič, má PAUZU"
        }



    }
}