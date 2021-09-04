package com.example.leech_60191680_midexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout, lay;
    ImageView imageView;
    TextView nou;
    TextView ore;
    TextView pie;
    TextView Q;
    TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이찬희 60191680 중간시험");

        setContentView(R.layout.activity_main);

        Button button3, button4;
        final ViewFlipper vFlipper;

        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        lay = (LinearLayout) findViewById(R.id.lay);
        imageView = (ImageView) findViewById(R.id.imageView);
        nou = (TextView) findViewById(R.id.nou);
        ore = (TextView) findViewById(R.id.ore);
        pie = (TextView) findViewById(R.id.pie);
        Q = (TextView) findViewById(R.id.Q);
        r = (TextView) findViewById(R.id.r);
        registerForContextMenu(imageView);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showPrevious();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showNext();
            }
        });

        nou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Nogut", Toast.LENGTH_LONG).show();
            }
        });
    }
    

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.subOri:
                imageView.setScaleX(1);
                imageView.setScaleY(1);
                return true;
            case R.id.subSize:
                imageView.setScaleX(2);
                imageView.setScaleY(2);
                return true;
        }
        return false;
    }
}