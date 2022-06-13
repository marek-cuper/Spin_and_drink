package com.example.spinyourdrink

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat


class MissionSettings : AppCompatActivity() {

    var listSwitchov = ArrayList<Switch>()
    var zeny = false
    var muzi = false

    @RequiresApi(Build.VERSION_CODES.O)
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
            if(!muzi){
                listSwitchov.add(3, switchMuzi)
            }
            if(!zeny){
                listSwitchov.add(4, switchZeny)
            }
            var listUloh = ArrayList<Int>()
            for (i in 0 until listSwitchov.size){
                if(listSwitchov[i].isChecked){
                    listUloh.add(i)
                }
            }

            notification()

            intent = Intent(this, MainSpin::class.java).apply {
                putExtra("listMien", listMien)
                putExtra("listPohlavi", listPohlavi)
                putExtra("listUloh", listUloh)
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun notification() {
        val channel : NotificationChannel = NotificationChannel("ID","ID", NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext)
            .setSmallIcon(android.R.drawable.btn_star_big_on) //set icon for notification
            .setContentTitle("Zatoč, vypi a ži!") //set title of notification
            .setContentText("Tak podme na vec!")
            .setChannelId("ID")//this is notification message
            .setAutoCancel(true) // makes auto cancel of notification
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //set priority of notification

        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())

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