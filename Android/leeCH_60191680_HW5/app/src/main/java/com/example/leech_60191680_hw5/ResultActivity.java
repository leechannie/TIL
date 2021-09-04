package com.example.leech_60191680_hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ResultActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("이찬희 과제5 투표 결과");
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");

        final ViewFlipper vFlipper = (ViewFlipper) findViewById(R.id.vFlip);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnStop = (Button) findViewById(R.id.btnStop);

        Integer rivID[] = {R.id.riv1, R.id.riv2, R.id.riv3, R.id.riv4, R.id.riv5, R.id.riv6, R.id.riv7, R.id.riv8, R.id.riv9};
        ImageView riv[] = new ImageView[9];
        Integer ImgID[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        //tmp를 임시 저장하고, tmpID를 리스트로 사용한다.
        int tmp;
        Integer tmpID;
        for (int i = 0; i < voteResult.length; i++) {
            for (int j = 0; j < voteResult.length - 1; j++) { //투표수를 비교해서 크면 앞으로 가게함
                if (voteResult[j] < voteResult[j + 1]) {
                    tmp = voteResult[j];
                    voteResult[j] = voteResult[j + 1];
                    voteResult[j + 1] = tmp;

                    tmpID = ImgID[j];
                    ImgID[j] = ImgID[j + 1];
                    ImgID[j + 1] = tmpID;
                }
            }
        }

        for (int i = 0; i < voteResult.length; i++) {
            riv[i]=(ImageView)findViewById(rivID[i]);
            riv[i].setImageResource(ImgID[i]);
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.startFlipping();
                vFlipper.setFlipInterval(1000);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });
    }
}