package com.divisions.smslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver  extends BroadcastReceiver
{
    public  String recievedSMS;
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";
    private String green = "Air is fresh and Clean";
    private String amber = "Room is stuffy ,Open windows";
    private String red = "FIRE ALAERT !";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i(TAG, "Intent recieved: " + intent.getAction());

        if (intent.getAction().equals(SMS_RECEIVED))
        {
            Bundle bundle = intent.getExtras();
            if (bundle != null)
            {
                Object[] pdus = (Object[])bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++)
                {
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                if (messages.length > -1)
                {
                    Toast.makeText(context, "Message recieved: " + messages[0].getMessageBody(), Toast.LENGTH_LONG).show();
                    recievedSMS = messages[0].getMessageBody();
                    updateDisplay(recievedSMS);
                }
            }
        }
    }

    public void updateDisplay(String code)
    {
        if(code.equals("000"))
        {
            MainActivity.frameLayout.setBackgroundColor(Color.GREEN);
            MainActivity.displayText.setText(green);
        }
        else if(code.equals("010"))
        {
            MainActivity.frameLayout.setBackgroundColor(Color.YELLOW);
            MainActivity.displayText.setText(amber);
        }
        else if(code.equals("111"))
        {
            MainActivity.frameLayout.setBackgroundColor(Color.RED);
            MainActivity.displayText.setText(red);
        }
    }
}
