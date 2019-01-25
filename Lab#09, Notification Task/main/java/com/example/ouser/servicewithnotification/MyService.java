package com.example.ouser.servicewithnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class MyService extends Service {
    String CHANNEL_ID = "first_channel";
    String CHANNEL_ID_2 = "second channel";
    NotificationCompat.Builder notification;
    NotificationManager notificationManager;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        buildPersistentNotification();
        Notification n = notification.build();
        startForeground(1,n);
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        buildNonPersistentNotification();
    }

    public void buildPersistentNotification(){
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            CharSequence channelName="Start Service Channel";
            int importance=NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);

            notificationManager.createNotificationChannel(channel);
        }

            notification = new NotificationCompat.Builder(getBaseContext(), CHANNEL_ID)
                    .setContentTitle("App Notification")
                    .setContentText("Service Running")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent)
                    .setStyle(new NotificationCompat.BigTextStyle());
            //notificationManager.notify(1, notification.build());
    }

    public void buildNonPersistentNotification(){
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            CharSequence channelName="Stop Service Channel";
            int importance=NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID_2, channelName, importance);
            notificationManager.createNotificationChannel(channel);
        }

        notification = new NotificationCompat.Builder(getBaseContext(), CHANNEL_ID)
                .setContentTitle("App Notification")
                .setContentText("Service Stopped")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle());
        notificationManager.notify(2, notification.build());
    }
}
