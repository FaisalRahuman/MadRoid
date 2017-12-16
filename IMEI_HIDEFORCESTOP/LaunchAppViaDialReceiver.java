package com.noshare;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class LaunchAppViaDialReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null && intent.getStringExtra("android.intent.extra.PHONE_NUMBER").equals("12345")) {
            setResultData(null);
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, MainActivity.class), 1, 1);
        }
    }
}

