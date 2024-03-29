package com.example.spinyourdrink

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

/**
 * @author Marek Cuper
 * Obrazovka ktorá slúži na nastavenie mien a pohlaví hráčov
 * */
class NamesSettings : AppCompatActivity() {
    private var pocetHracov = 0
    private var listMien = ArrayList<String>()
    private var listPohlavi = ArrayList<String>()
    private var zobrazenieText = ArrayList<EditText>()
    private var zobrazenieSwitch = ArrayList<Switch>()

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceType", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("NamesSettings", "onCreate called")
        setContentView(R.layout.activity_names_settings)
        pocetHracov = 3

        val pokracovatButton = findViewById<Button>(R.id.pokracovatButtonNames)

        val hraciSeekBar = findViewById<SeekBar>(R.id.numOfPlayers)

        val textHrac1 = findViewById<EditText>(R.id.EditTextHrac1)
        val textHrac2 = findViewById<EditText>(R.id.EditTextHrac2)
        val textHrac3 = findViewById<EditText>(R.id.EditTextHrac3)
        val textHrac4 = findViewById<EditText>(R.id.EditTextHrac4)
        val textHrac5 = findViewById<EditText>(R.id.EditTextHrac5)
        val textHrac6 = findViewById<EditText>(R.id.EditTextHrac6)
        val switchHrac1 = findViewById<Switch>(R.id.pohlavie1)
        val switchHrac2 = findViewById<Switch>(R.id.pohlavie2)
        val switchHrac3 = findViewById<Switch>(R.id.pohlavie3)
        val switchHrac4 = findViewById<Switch>(R.id.pohlavie4)
        val switchHrac5 = findViewById<Switch>(R.id.pohlavie5)
        val switchHrac6 = findViewById<Switch>(R.id.pohlavie6)

        zobrazenieText.add(textHrac4)
        zobrazenieText.add(textHrac5)
        zobrazenieText.add(textHrac6)
        zobrazenieSwitch.add(switchHrac4)
        zobrazenieSwitch.add(switchHrac5)
        zobrazenieSwitch.add(switchHrac6)

        /**
         * Zobrazenie switchov podľa počtu hráčov(na SeekBar)
         */
        for (i in 0..2){
            zobrazenieText[i].visibility = View.INVISIBLE
            zobrazenieSwitch[i].visibility = View.INVISIBLE
        }
        hraciSeekBar.progress = 0

        hraciSeekBar?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(hraciSeekBar: SeekBar,
                                           progress: Int, fromUser: Boolean) {
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                for (i in 0..2){
                    if(hraciSeekBar.progress > i){
                        zobrazenieText[i].visibility = View.VISIBLE
                        zobrazenieSwitch[i].visibility = View.VISIBLE

                    } else{
                        zobrazenieText[i].visibility = View.INVISIBLE
                        zobrazenieSwitch[i].visibility = View.INVISIBLE
                    }
                }
            }
        })
        /**
         * Listeneri
         */
        pokracovatButton.setOnClickListener {

            notification()
            pocetHracov += hraciSeekBar.progress
            listMien.add(textHrac1.text.toString())
            listMien.add(textHrac2.text.toString())
            listMien.add(textHrac3.text.toString())
            listPohlavi.add(pohlavieString(switchHrac1.isChecked))
            listPohlavi.add(pohlavieString(switchHrac2.isChecked))
            listPohlavi.add(pohlavieString(switchHrac3.isChecked))
            if(pocetHracov > 3){
                listMien.add(textHrac4.text.toString())
                listPohlavi.add(pohlavieString(switchHrac4.isChecked))
                if(pocetHracov > 4){
                    listMien.add(textHrac5.text.toString())
                    listPohlavi.add(pohlavieString(switchHrac5.isChecked))
                    if(pocetHracov > 5){
                        listMien.add(textHrac6.text.toString())
                        listPohlavi.add(pohlavieString(switchHrac6.isChecked))
                    }
                }
            }
            for (i in 0 until listMien.size) {
                if(listMien[i] == ""){
                    listMien[i] = "hrac" + (i + 1)
                }
            }

            val intent = Intent(this,MissionSettings::class.java).apply {
                putExtra("listMien", listMien)
                putExtra("listPohlavi", listPohlavi)
            }
            startActivity(intent)
        }


        switchHrac1.setOnClickListener {
            if(switchHrac1.isChecked){
                textHrac1.setBackgroundColor(Color.parseColor(getString(R.color.girls)))
            } else{
                textHrac1.setBackgroundColor(Color.parseColor(getString(R.color.boys)))
            }
        }

        switchHrac2.setOnClickListener {
            if(switchHrac2.isChecked){
                textHrac2.setBackgroundColor(Color.parseColor(getString(R.color.girls)))
            } else{
                textHrac2.setBackgroundColor(Color.parseColor(getString(R.color.boys)))
            }
        }

        switchHrac3.setOnClickListener {
            if(switchHrac3.isChecked){
                textHrac3.setBackgroundColor(Color.parseColor(getString(R.color.girls)))
            } else{
                textHrac3.setBackgroundColor(Color.parseColor(getString(R.color.boys)))
            }
        }

        switchHrac4.setOnClickListener {
            if(switchHrac4.isChecked){
                textHrac4.setBackgroundColor(Color.parseColor(getString(R.color.girls)))
            } else{
                textHrac4.setBackgroundColor(Color.parseColor(getString(R.color.boys)))
            }
        }

        switchHrac5.setOnClickListener {
            if(switchHrac5.isChecked){
                textHrac5.setBackgroundColor(Color.parseColor(getString(R.color.girls)))
            } else{
                textHrac5.setBackgroundColor(Color.parseColor(getString(R.color.boys)))
            }
        }

        switchHrac6.setOnClickListener {
            if(switchHrac6.isChecked){
                textHrac6.setBackgroundColor(Color.parseColor(getString(R.color.girls)))
            } else{
                textHrac6.setBackgroundColor(Color.parseColor(getString(R.color.boys)))
            }
        }

    }

    override fun onBackPressed() {
    }

    override fun onStart() {
        super.onStart()
        Log.i("NameSettings", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("NameSettings", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("NameSettings", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("NameSettings", "onStop called")
    }

    /**
     * Funkcia slúži na zobrazenie notifikácie
     */
    @Suppress("DEPRECATION")
    @RequiresApi(Build.VERSION_CODES.O)
    fun notification() {
        val channel = NotificationChannel("ID","ID", NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext)
            .setSmallIcon(android.R.drawable.stat_sys_warning) //set icon for notification
            .setContentTitle("Vyber misie") //set title of notification
            .setContentText("Vyber si misie ktoré zabavia teba aj tvojich kamošov!")
            .setChannelId("ID")//this is notification message
            .setAutoCancel(true) // makes auto cancel of notification
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //set priority of notification

        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())
    }

    /**
     * @param pohlavie zo switchu True/False
     * @return zena/muz
     * Funkcia slúži na vrátenie zeny/muza podla booleanu
     */
    private fun pohlavieString(pohlavie: Boolean): String {
        return if(pohlavie){
            "zena"
        } else{
            "muz"
        }
    }
}