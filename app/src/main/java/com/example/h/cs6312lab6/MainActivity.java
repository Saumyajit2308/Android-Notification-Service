package com.example.h.cs6312lab6;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationCompat.Builder notification_builder;
    private NotificationManagerCompat notification_manager;
    private int notification_id=1;
    private Button btn;
    private String message="Notification Triggered";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);

                Intent open_activity_intent=  new Intent(MainActivity.this,NotificationActivity.class);
                open_activity_intent.putExtra("message", message);
                PendingIntent pending_intent =PendingIntent.getActivity(MainActivity.this,0,open_activity_intent,PendingIntent.FLAG_CANCEL_CURRENT);
                notification_builder=new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_check_circle_black_24dp)
                        .setContentTitle("Happy Days!!!")
                        .setContentText(message)
                        .setAutoCancel(true)
                        .setLights(0xff00ff00, 300, 100)
                        .setContentIntent(pending_intent)
                        .setVibrate(new long[]{500,500,500,500})
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                notification_manager =NotificationManagerCompat.from(MainActivity.this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification_manager.notify(notification_id,notification_builder.build());

            }
        });


    }
}
