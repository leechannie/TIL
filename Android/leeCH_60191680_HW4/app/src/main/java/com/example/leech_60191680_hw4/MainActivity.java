package com.example.leech_60191680_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    final static int LINE = 1, CIRCLE = 2, RECTANGLE0 = 3, RECTANGLE5 = 4, RECTANGLE9 = 5, FILLR=6, STROKER=7;
    static int curShape = LINE;
    static int curColor = Color.GREEN;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("이찬희19 과제4 타이틀");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        SubMenu sMenu1 = menu.addSubMenu("모서리가 둥근 사각형 그리기 >>");
        sMenu1.add(0, 3, 0, "0%");
        sMenu1.add(0, 4, 0, "50%");
        sMenu1.add(0, 5, 0, "90%");

        SubMenu sMenu2 = menu.addSubMenu("채우기 >>");
        sMenu2.add(0, 6, 0, "채우기");
        sMenu2.add(0, 7, 0, "테두리만");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECTANGLE0; // 둥근 사각형
                return true;
            case 4:
                curShape = RECTANGLE5; // 둥근 사각형
                return true;
            case 5:
                curShape = RECTANGLE9; // 둥근 사각형
                return true;
            case 6:
                curShape = FILLR; // 채우기
                return true;
            case 7:
                curShape = STROKER; // 테두리만
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        Path path1 = new Path();
        int flag = 0;

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    flag ++;
                    this.invalidate();
                    break;
            }
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);
            String i = Integer.toString(startX);
            switch (curShape) {
                case LINE:
                    if (flag <=1) {
                        path1.moveTo(startX, startY);
                    }
                    path1.lineTo(stopX, stopY);
                    canvas.drawPath(path1, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                            + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case RECTANGLE0:
                    RectF rect2 = new RectF(startX, startY, stopX, stopY);
                    canvas.drawRoundRect(rect2, 0, 0, paint);
                    break;
                case RECTANGLE5:
                    RectF rect5 = new RectF(startX, startY, stopX, stopY);
                    canvas.drawRoundRect(rect5, 50, 50, paint);
                    break;
                case RECTANGLE9:
                    RectF rect9 = new RectF(startX, startY, stopX, stopY);
                    canvas.drawRoundRect(rect9, 90, 90, paint);
                    break;
                case FILLR:
                    paint.setStyle(Paint.Style.FILL);
                    Rect rectF = new Rect(startX, startY, stopX, stopY);
                    canvas.drawRect(rectF, paint);
                    break;
                case STROKER:
                    paint.setStyle(Paint.Style.STROKE);
                    Rect rectS = new Rect(startX, startY, stopX, stopY);
                    canvas.drawRect(rectS, paint);
                    break;
            }
        }

    }
}