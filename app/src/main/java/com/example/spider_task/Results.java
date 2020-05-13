package com.example.spider_task;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class Results extends AppCompatActivity {
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        relativeLayout=(RelativeLayout)findViewById(R.id.result);
        TextView textView=(TextView)findViewById(R.id.winner);
        Intent intent=getIntent();
        int i=intent.getIntExtra("comp",0);
        textView.setText(intent.getStringExtra("winner"));
        if(i==1){
            relativeLayout.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
