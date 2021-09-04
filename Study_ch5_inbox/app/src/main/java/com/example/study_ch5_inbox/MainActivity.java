package com.example.study_ch5_inbox;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout purple, blue, yellow, black;
    private int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        purple = findViewById(R.id.purple);
        blue = findViewById(R.id.blue);
        yellow = findViewById(R.id.yellow);
        black = findViewById(R.id.black);

        MyListener listener = new MyListener(); //리스너 객체 생성
        purple.setOnClickListener(listener);
        blue.setOnClickListener(listener);
        yellow.setOnClickListener(listener);
        black.setOnClickListener(listener);
    }

    public class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v){
            width = 0;
            height = 0;
            switch(v.getId()){
                case R.id.purple:
                    width = purple.getWidth();
                    height = purple.getHeight();
                    break;
                case R.id.blue:
                    width = blue.getWidth();
                    height = blue.getHeight();
                    break;
                case R.id.yellow:
                    width = yellow.getWidth();
                    height = yellow.getHeight();
                    break;
                case R.id.black:
                    width = black.getWidth();
                    height = black.getHeight();
                    break;
            }
            Toast.makeText(getApplicationContext(), "가로 : " + width + ", 세로 : " + height, Toast.LENGTH_SHORT).show();
        }
    }
}