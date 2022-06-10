package com.example.spinyourdrink

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MissionSettings : AppCompatActivity() {

    var listUlohy = ArrayList<Boolean>()
    var listSwitchov = ArrayList<Switch>()
    var zeny = false
    var muzi = false

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_settings)

        //data z predosleho fragmentu
        val listMien = intent.getStringArrayListExtra("listMien")
        val listPohlavi = intent.getStringArrayListExtra("listPohlavi")

        //button a switche
        val pokracovatButton = findViewById<Button>(R.id.pokracovatButtonMission)

        val switchVypi = findViewById<Switch>(R.id.switchVypi)
        val switchVypi2 = findViewById<Switch>(R.id.switchVypi2)
        val switchPartner = findViewById<Switch>(R.id.switchPartner)
        val switchMuzi = findViewById<Switch>(R.id.switchMuzi)
        val switchZeny = findViewById<Switch>(R.id.switchZeny)
        val switchVsetci = findViewById<Switch>(R.id.switchVsetci)
        val switchNalej = findViewById<Switch>(R.id.switchNalej)
        val switchStastlivec = findViewById<Switch>(R.id.switchStastlivec)
        val switchDrepy = findViewById<Switch>(R.id.switch_drepy)
        val switchPauza = findViewById<Switch>(R.id.switch_pauza)

        val textViewUpozornenie = findViewById<TextView>(R.id.upozornenieMission)


        if (listPohlavi != null) {
            for (i in 0 until listPohlavi.size){
                if(listPohlavi[i] == "zena"){
                    zeny = true
                } else{
                    muzi = true
                }
            }
        }

        //ukladanie switchov do arraylistu
        listSwitchov.add(switchVypi)
        listSwitchov.add(switchVypi2)
        listSwitchov.add(switchPartner)
        if(muzi){
            listSwitchov.add(switchMuzi)
        }
        if(zeny){
            listSwitchov.add(switchZeny)
        }
        listSwitchov.add(switchVsetci)
        listSwitchov.add(switchNalej)
        listSwitchov.add(switchStastlivec)
        listSwitchov.add(switchDrepy)
        listSwitchov.add(switchPauza)

        pokracovatButton.setOnClickListener() {

            for (i in 0 until listSwitchov.size){
                listUlohy.add(listSwitchov[i].isChecked)
            }

            intent = Intent(this, MainSpin::class.java).apply {
                putExtra("listMien", listMien)
                putExtra("listPohlavi", listPohlavi)
                putExtra("listUloh", listUlohy)
            }
            startActivity(intent)

        }


        switchVypi.setOnClickListener() {
            minimum()
        }
        switchVypi2.setOnClickListener() {
            minimum()
        }
        switchPartner.setOnClickListener() {
            minimum()
        }
        switchMuzi.setOnClickListener() {
            if(muzi){
                minimum()
            } else{
                switchMuzi.isChecked = false
                textViewUpozornenie.setText(getString(R.string.muzi_misia))
                textViewUpozornenie.visibility = View.VISIBLE
            }
        }
        switchZeny.setOnClickListener() {
            if(zeny){
                minimum()
            } else{
                switchZeny.isChecked = false
                textViewUpozornenie.setText(getString(R.string.zeny_misia))
                textViewUpozornenie.visibility = View.VISIBLE
            }
        }
        switchVsetci.setOnClickListener() {
            minimum()
        }
        switchNalej.setOnClickListener() {
            minimum()
        }
        switchStastlivec.setOnClickListener() {
            minimum()
        }
        switchDrepy.setOnClickListener() {
            minimum()
        }
        switchPauza.setOnClickListener() {
            minimum()
        }

    }
    fun minimum() {
        val pocUloh = pocetUloh()
        if(pocUloh < 5){
            val textViewUpozornenie = findViewById<TextView>(R.id.upozornenieMission)
            textViewUpozornenie.setText(getString(R.string.minimum_misii))
            textViewUpozornenie.visibility = View.VISIBLE

            var cislo = (0 until listSwitchov.size).random()
            while (listSwitchov[cislo].isChecked){
                cislo = (0 until listSwitchov.size).random()
            }
            listSwitchov[cislo].isChecked = true
        }
    }

    fun pocetUloh(): Int {
        var pocetUloh = 0
        for (i in 0 until listSwitchov.size){
            if(listSwitchov[i].isChecked){
                pocetUloh++
            }
        }
        return pocetUloh
    }
}