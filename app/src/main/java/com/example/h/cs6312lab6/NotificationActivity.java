package com.example.h.cs6312lab6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificationActivity extends Activity {
    private Button btn1;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btn1=(Button)findViewById(R.id.button1);
        text=(TextView)findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        text.setText(message);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NotificationActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
