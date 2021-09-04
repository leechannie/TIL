package com.example.week12_rating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");

        // intent 객체와 객체 내 데이터 받기
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        // 9개의 TextView, RatingBar 객체배열
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        // 9개의 TextView, RatingBar ID 배열
        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        // TextView, RatingBar에 MainActivity로 부터 받은 데이터 값을 반영
        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            tv[i].setText(imageName[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });

    }
}
