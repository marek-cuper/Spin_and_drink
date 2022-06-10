package com.example.spinyourdrink

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity


class MissionSettings : AppCompatActivity() {

    var listUlohy = ArrayList<Boolean>()

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_settings)

        val pokracovatButton = findViewById<Button>(R.id.pokracovatButtonMission)


        pokracovatButton.setOnClickListener() {

            val switchVypi = findViewById<Switch>(R.id.switchVypi)
            listUlohy.add(switchVypi.isChecked)
            val switchVypi2 = findViewById<Switch>(R.id.switchVypi2)
            listUlohy.add(switchVypi2.isChecked)
            val switchPartner = findViewById<Switch>(R.id.switchPartner)
            listUlohy.add(switchPartner.isChecked)
            val switchMuzi = findViewById<Switch>(R.id.switchMuzi)
            listUlohy.add(switchMuzi.isChecked)
            val switchZeny = findViewById<Switch>(R.id.switchZeny)
            listUlohy.add(switchZeny.isChecked)
            val switchVsetci = findViewById<Switch>(R.id.switchVsetci)
            listUlohy.add(switchVsetci.isChecked)
            val switchNalej = findViewById<Switch>(R.id.switchNalej)
            listUlohy.add(switchNalej.isChecked)
            val switchStastlivec = findViewById<Switch>(R.id.switchStastlivec)
            listUlohy.add(switchStastlivec.isChecked)
            val switchDrepy = findViewById<Switch>(R.id.switch_drepy)
            listUlohy.add(switchDrepy.isChecked)
            val switchPauza = findViewById<Switch>(R.id.switch_pauza)
            listUlohy.add(switchPauza.isChecked)


            val zoznamMien = intent.getStringArrayListExtra("zoznamMien")
            val zoznamPohlavi = intent.getStringArrayListExtra("zoznamPohlavi")
            intent = Intent(this, MainSpin::class.java).apply {
                putExtra("zoznamMien", zoznamMien)
                putExtra("zoznamPohlavi", zoznamPohlavi)
                putExtra("zoznamUloh", listUlohy)
            }
            startActivity(intent)

        }

    }
}