package com.example.week5_ch6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton radioCal, radioTime;
    CalendarView calView;
    TimePicker timePicker;
    TextView txtYear, txtMonth, txtDay, txtHour, txtMinute;
    int selYear, selMonth, selDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("19이찬희_출석과제5");
        // 버튼
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        // 크로노미터
        chronometer = (Chronometer) findViewById(R.id.chronometer);

        // 라디오버튼 2개
        radioCal = (RadioButton) findViewById(R.id.radioCal);
        radioTime = (RadioButton) findViewById(R.id.radioTime);

        // FrameLayout의 2개 위젯
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        calView = (CalendarView) findViewById(R.id.calendarView1);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        txtYear = (TextView) findViewById(R.id.txtYear);
        txtMonth = (TextView) findViewById(R.id.txtMonth);
        txtDay = (TextView) findViewById(R.id.txtDay);
        txtHour = (TextView) findViewById(R.id.txtHour);
        txtMinute = (TextView) findViewById(R.id.txtMinute);

        // 처음에는 2개를 안보이게 설정
        timePicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        radioCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });
        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                txtYear.setText(Integer.toString(selYear));
                txtMonth.setText(Integer.toString(selMonth));
                txtDay.setText(Integer.toString(selDay));
                txtHour.setText(Integer.toString(timePicker.getCurrentHour()));
                txtMinute.setText(Integer.toString(timePicker.getCurrentMinute()));
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selYear = year;
                selMonth = month+1;
                selDay = day;
            }
        });
    }
}