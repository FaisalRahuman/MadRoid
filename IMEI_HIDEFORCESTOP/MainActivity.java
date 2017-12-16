package com.noshare;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Process;

public class MainActivity extends AppCompatActivity {
    Button forceStop;
    TextView tvUIDS,ed;
    String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUIDS = (TextView) findViewById(R.id.tv_uids);
        StringBuilder sb = new StringBuilder();
        TelephonyManager telMan = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        ed = (TextView) findViewById(R.id.ed);
        
        x = telMan.getDeviceId();
        ed.setText("IMEI:" + x + "\n");
        WifiManager wm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        String mac_adr = wm.getConnectionInfo().getMacAddress();
        if (mac_adr != null) {
            sb.append("WLAN MAC ADDRESS:" + mac_adr + "\n");
        }
        else {
            sb.append("WLAN MAC ADDRESS: not supported on this device\n");
        }
        tvUIDS.setText(sb.toString());
        findViewById(R.id.log_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager packageManager = getApplicationContext().getPackageManager();
                ComponentName componentName = new ComponentName(getApplicationContext(),
                        MainActivity.class);
                packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP);
            }
        });
        forceStop = (Button) findViewById(R.id.force_stop);
        forceStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}

