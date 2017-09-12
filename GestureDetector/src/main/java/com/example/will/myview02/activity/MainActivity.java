package com.example.will.myview02.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.will.myview02.R;
import com.example.will.myview02.desturedetector.MyGestureDetector;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureDetector = new GestureDetector(this, new MyGestureDetector());

        GestureDetector();
    }

    private void GestureDetector() {
        findViewById(R.id.btn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mGestureDetector.onTouchEvent(event);
                /**
                 * 返回true就是为了接收到所有的事件,关于onTouch和onclick的问题参见郭林博客???
                 */
                return true;
            }
        });
    }
}
