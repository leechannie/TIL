package com.example.week11_miniphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1; //버튼을 누를 때 확대될 정도
    static float angle = 0; //버튼 앵글 정도
    static float color = 1; //버튼 색 정도
    static float satur = 1; //0,1로 색 변환

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true); //액션바 자리 만들기
        getSupportActionBar().setIcon(R.drawable.picture);
        setTitle("60191680 이찬희 미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons() { //아이콘 이벤트 리스너
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright); //밝게
        ibBright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });

        ibGray = (ImageButton) findViewById(R.id.ibGray);
        ibGray.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (satur == 0)
                    satur = 1;
                else
                    satur = 0;
                graphicView.invalidate();
            }
        });

    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = { color, 0, 0, 0, 0, //R
                               0, color, 0, 0, 0, //G
                               0, 0, color, 0, 0, //B
                               0, 0, 0, 1, 0 };
            ColorMatrix cm = new ColorMatrix(array);

            if (satur == 0)
                cm.setSaturation(satur); //채도 정보(색)을 있고, 없고 조절

            paint.setColorFilter(new ColorMatrixColorFilter(cm)); //컬러 필터 적용

            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.photo);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }
}
