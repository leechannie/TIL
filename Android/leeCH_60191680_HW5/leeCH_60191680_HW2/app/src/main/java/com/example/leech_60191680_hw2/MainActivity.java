package com.example.leech_60191680_hw2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    RadioButton radioCal, radioTime;
    DatePicker datePick;
    TimePicker timePicker;
    TextView txtYear, txtMonth, txtDay, txtHour, txtMinute;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("19이찬희 과제2 시간예약"); //동명이인이 있습니다,,,

        // 크로노미터
        chronometer = (Chronometer) findViewById(R.id.chronometer);

        // 라디오버튼 2개
        radioCal = (RadioButton) findViewById(R.id.radioCal);
        radioTime = (RadioButton) findViewById(R.id.radioTime);

        // FrameLayout의 2개 위젯
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        datePick = (DatePicker) findViewById(R.id.datePick);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        txtYear = (TextView) findViewById(R.id.txtYear);
        txtMonth = (TextView) findViewById(R.id.txtMonth);
        txtDay = (TextView) findViewById(R.id.txtDay);
        txtHour = (TextView) findViewById(R.id.txtHour);
        txtMinute = (TextView) findViewById(R.id.txtMinute);

        // 처음에는 5개를 안보이게 설정
        radioCal.setVisibility(View.INVISIBLE);
        radioTime.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);
        datePick.setVisibility(View.INVISIBLE);


        //캘린더 라디오
        radioCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                datePick.setVisibility(View.VISIBLE);
            }
        });

        // 타이머 라디오
        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                datePick.setVisibility(View.INVISIBLE);
            }
        });

        //타이머 시작 + 라디오 보이기
        chronometer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);

                radioCal.setVisibility(View.VISIBLE);
                radioTime.setVisibility(View.VISIBLE);
            }
        });
        //타이머 종료 + 날짜 시간 입력 + 라디오 숨김
        txtYear.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onLongClick(View view) {
                //타이머 종료
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                // 날짜 시간 입력
                txtYear.setText(Integer.toString(datePick.getYear()));
                txtMonth.setText(Integer.toString(datePick.getMonth()+1));
                txtDay.setText(Integer.toString(datePick.getDayOfMonth()));
                txtHour.setText(Integer.toString(timePicker.getCurrentHour()));
                txtMinute.setText(Integer.toString(timePicker.getCurrentMinute()));

                //라디오 숨김
                radioCal.setVisibility(View.INVISIBLE);
                radioTime.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                datePick.setVisibility(View.INVISIBLE);

                return true;
            }
        });

        // 예약 종류 자동완성
        String[] items = { "class", "exam", "homework", "quiz", "meeting", "wake-up", "appointment", "birthday" };

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);
    }

}