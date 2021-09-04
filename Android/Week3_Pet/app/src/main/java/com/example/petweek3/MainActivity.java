package com.example.petweek3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox checkStart;
    RadioGroup rGroup;
    RadioButton radioDog, radioCat, radioAlpaca;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");
        text1 = (TextView) findViewById(R.id.Text1);
        checkStart = (CheckBox) findViewById(R.id.CheckStart);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup = (RadioGroup) findViewById(R.id.Rgroup);
        radioDog = (RadioButton) findViewById(R.id.Radiodog);
        radioCat = (RadioButton) findViewById(R.id.Radiocat);
        radioAlpaca = (RadioButton) findViewById(R.id.Radioalpaca);
        btnOK = (Button) findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        checkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkStart.isChecked() == true){
                    text2.setVisibility((View.VISIBLE));
                    rGroup.setVisibility((View.VISIBLE));
                    btnOK.setVisibility((View.VISIBLE));
                    imgPet.setVisibility((View.VISIBLE));
                }
                else {
                    text2.setVisibility((View.INVISIBLE));
                    rGroup.setVisibility((View.INVISIBLE));
                    btnOK.setVisibility((View.INVISIBLE));
                    imgPet.setVisibility((View.INVISIBLE));
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.Radiodog:
                        imgPet.setImageResource(R.drawable.dog); break;
                    case R.id.Radiocat:
                        imgPet.setImageResource(R.drawable.cat); break;
                    case R.id.Radioalpaca:
                        imgPet.setImageResource(R.drawable.alpaca); break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택바람람", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}