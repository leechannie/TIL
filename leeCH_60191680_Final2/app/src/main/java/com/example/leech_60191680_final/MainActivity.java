package com.example.leech_60191680_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView  =(TextView) findViewById(R.id.textView);

        //시작하면 오늘 날짜에 처음 가도록 설정
        MaterialCalendarView materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.setSelectedDate(CalendarDay.today());



    }
}