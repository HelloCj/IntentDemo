package com.example.chengjie.intentdemo;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION = "com.example.newapp";
    private Button btn_intent;

    PackageInfo packageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_intent = (Button) findViewById(R.id.btn_intent);

        try {
            packageInfo = getPackageManager().getPackageInfo("com.example.newapp", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (packageInfo == null) {
                    Toast.makeText(MainActivity.this, "未安装网络测试", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setAction(ACTION);
                    intent.putExtra("data", "你好，新应用");
                    startActivity(intent);
                }
            }
        });
    }
}
