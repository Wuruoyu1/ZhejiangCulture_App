package com.android.history.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.history.R;


/**
 * 明细
 */
public class InfoDetailActivity extends AppCompatActivity {
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_detail);
        ivImage = findViewById(R.id.image);
        tvTitle = findViewById(R.id.title);
        tvContent = findViewById(R.id.content);
        int image = getIntent().getIntExtra("image", 0);
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        ivImage.setImageResource(image);
        tvTitle.setText(title);
        tvContent.setText(content);
    }
}
