package com.example.newapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_intent = (TextView) findViewById(R.id.tv_intent);
        String data = getIntent().getStringExtra("data");
        tv_intent.setText(data);
    }
}
