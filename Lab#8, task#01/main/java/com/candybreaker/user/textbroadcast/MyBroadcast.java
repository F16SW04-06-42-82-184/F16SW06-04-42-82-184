package com.candybreaker.user.textbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {
    final SmsManager manager = SmsManager.getDefault();
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            Object [] pdus = (Object[]) bundle.get("pdus");
            SmsMessage manager = SmsMessage.createFromPdu((byte[]) pdus[0]);
            String SMS, Number;
            SMS = manager.getDisplayMessageBody().toString();
            String hello = "hello";
            if(SMS.toLowerCase().contains(hello)){
                Toast.makeText(context, SMS, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
