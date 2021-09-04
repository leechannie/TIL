package com.example.week7_plg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2; //직접 찾을 수 X

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment2 = new Fragment2();
    }
    public  void  onFragmentChanged(int index) {
        if (index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        } else if (index == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();

        }
    }
}