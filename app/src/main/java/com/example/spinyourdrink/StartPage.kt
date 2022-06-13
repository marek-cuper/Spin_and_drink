package com.example.spinyourdrink

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class StartPage : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        var button = findViewById<Button>(R.id.start_button)

        button.setOnClickListener() {
            notification()
            val intent = Intent(this,NamesSettings::class.java)
            startActivity(intent)
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun notification() {
        val channel : NotificationChannel = NotificationChannel("ID","ID", NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext)
            .setSmallIcon(android.R.drawable.stat_sys_warning) //set icon for notification
            .setContentTitle("Pridaj hráťov") //set title of notification
            .setContentText("Nezabudni pridať všetkých pri stole!")
            .setChannelId("ID")//this is notification message
            .setAutoCancel(true) // makes auto cancel of notification
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //set priority of notification

        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())

    }


}