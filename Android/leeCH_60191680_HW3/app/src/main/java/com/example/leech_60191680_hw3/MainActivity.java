package com.example.leech_60191680_hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText answer;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("뻥이요 맛나요~");

        answer = (EditText)findViewById(R.id.answer);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:
                imageView.setRotation(Float.parseFloat(answer.getText()
                        .toString()));
                return true;
            case R.id.item1:
                imageView.setImageResource(R.drawable.gold);
                return true;
            case R.id.item2:
                imageView.setImageResource(R.drawable.honey);
                return true;
            case R.id.item3:
                imageView.setImageResource(R.drawable.banana);
                return true;
        }
        return false;
    }

}