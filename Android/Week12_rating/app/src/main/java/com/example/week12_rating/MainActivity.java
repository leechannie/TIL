package com.example.week12_rating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("명화 선호도 투표");

        // 버튼 위젯 변수 선언
        Button btnReselt = (Button) findViewById(R.id.btnResult);

        //9개의 ImageView 위젯과 id 저장 배열 선언
        ImageView image[] = new ImageView[9];
        // 9개의 이미지버튼 ID 배열
        Integer imgId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};

        //그림 제목 배열 선언
        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서"};

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;

        for (int i = 0; i < imgId.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imgId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    // 투표수 증가.
                    voteCount[index]++;
                    String msg = imgName[index] + ":총" + voteCount[index] + "표";
                    Toast.makeText(getApplicationContext(),
                            msg, Toast.LENGTH_SHORT).show();
                }
            });
        }


        btnReselt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });

    }
}