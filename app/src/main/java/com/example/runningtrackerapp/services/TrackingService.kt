package com.example.runningtrackerapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.utils.Constants.ACTION_PAUSE_SERVICE
import com.example.runningtrackerapp.utils.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.example.runningtrackerapp.utils.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.runningtrackerapp.utils.Constants.ACTION_STOP_SERVICE
import com.example.runningtrackerapp.utils.Constants.NOTIFICATION_CHANNEL_ID
import com.example.runningtrackerapp.utils.Constants.NOTIFICATION_CHANNEL_NAME
import com.example.runningtrackerapp.utils.Constants.NOTIFICATION_ID
import com.example.runningtrackerapp.view.MainActivity
import timber.log.Timber

class TrackingService : LifecycleService() {

    var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRun){
                        startForegroundService()
                        isFirstRun = false
                    } else {
                        Timber.d("Resumiendo servicio")
                    }
                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Servicio pausado")
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Servicio detendo")
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForegroundService() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_run)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingintent())

        startForeground(NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun getMainActivityPendingintent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this,MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager){
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW)
        notificationManager.createNotificationChannel(channel)
    }
}