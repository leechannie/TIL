package com.example.a60191680_h1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch checkStart;
    RadioGroup rGroup;
    RadioButton radiov, radioch, radioco,radios;
    Button btnend, btnfirst ;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좋아하는 아이스크림 맛 고르기");

        // 변수와 xml 객체 mapping
        text1 = (TextView) findViewById(R.id.Text1);
        checkStart = (Switch) findViewById(R.id.CheckStart);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup = (RadioGroup) findViewById(R.id.Rgroup);
        radiov = (RadioButton) findViewById(R.id.RadioV);
        radioch = (RadioButton) findViewById(R.id.RadioCh);
        radioco = (RadioButton) findViewById(R.id.RadioCo);
        radios = (RadioButton) findViewById(R.id.RadioS);
        btnend = (Button) findViewById(R.id.BtnEnd);
        btnfirst = (Button) findViewById(R.id.BtnFirst);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        // switch로 보였다 닫았다 기능 구현
        checkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkStart.isChecked() == true){
                    text2.setVisibility((View.VISIBLE));
                    rGroup.setVisibility((View.VISIBLE));
                    imgPet.setVisibility((View.VISIBLE));
                }
                else {
                    text2.setVisibility((View.INVISIBLE));
                    rGroup.setVisibility((View.INVISIBLE));
                    imgPet.setVisibility((View.INVISIBLE));
                }
            }
        });

        // 누르면 바로 바뀔 수 있게 각 radio에 이벤트 리스너 달기
        radiov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPet.setImageResource(R.drawable.vainilla);
            }
        });
        radioch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPet.setImageResource(R.drawable.choco);
            }
        });
        radioco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPet.setImageResource(R.drawable.coffee);
            }
        });
        radios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPet.setImageResource(R.drawable.strawberry);
            }
        });

        // 종료 버튼에 finish랑 toast 달기
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "안녕히 가세요. 또 만나요.", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        // 초기화 버튼에 초기랑 같은 설정으로 설정해주기
        btnfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setVisibility((View.INVISIBLE));
                rGroup.setVisibility((View.INVISIBLE));
                imgPet.setVisibility((View.INVISIBLE));
                checkStart.setChecked(false);
                imgPet.setImageResource(R.drawable.vainilla);
            }
        });
    }

}