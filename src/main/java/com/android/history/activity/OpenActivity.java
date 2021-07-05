package com.android.history.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.history.R;


public class OpenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //两秒后跳转到主页面
                Intent intent2 = new Intent(OpenActivity.this,LoginActivity.class);
                startActivity(intent2);
                finish();
            }
        }, 2000);
    }
}
