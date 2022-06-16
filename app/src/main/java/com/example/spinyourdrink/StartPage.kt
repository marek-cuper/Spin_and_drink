package com.example.spinyourdrink

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

/**
 * @author Marek Cuper
 * Úvodná obrazovka
 * */
class StartPage : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("StartPage", "onCreate called")



        setContentView(R.layout.activity_start_page)

        val button = findViewById<Button>(R.id.start_button)

        /**
         * Listeneri
         */
        button.setOnClickListener {
            notification()
            val intent = Intent(this,NamesSettings::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
    }

    override fun onStart() {
        super.onStart()
        Log.i("StartPage", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("StartPage", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("StartPage", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("StartPage", "onStop called")
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
            .setContentTitle("Pridaj hráčov") //set title of notification
            .setContentText("Nezabudni pridať všetkých za stolom!")
            .setChannelId("ID")//this is notification message
            .setAutoCancel(true) // makes auto cancel of notification
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //set priority of notification

        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())
    }


}