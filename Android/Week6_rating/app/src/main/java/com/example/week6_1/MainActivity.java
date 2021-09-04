package com.example.week6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupRatingBar();
    }

    public void SetupRatingBar () {
       ratingBar = (RatingBar) findViewById(R.id.ratingBar);
       value = (TextView) findViewById(R.id.value);

       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               value.setText(Float.toString(v));
           }
       });
    }
}