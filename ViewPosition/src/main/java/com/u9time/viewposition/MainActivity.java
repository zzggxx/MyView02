package com.u9time.viewposition;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn);

        // TODO: 2017/9/18 绘制完毕才能拿到其坐标值.
        mButton.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mButton.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    mButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                Log.i(TAG, "onCreate: left = " + mButton.getLeft()
                        + "top = " + mButton.getTop()
                        + "right = " + mButton.getRight()
                        + "bottom = " + mButton.getBottom());
            }
        });

        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /*不区分MotionEvent的话就会回调几次的,看事件了*/
                Log.i(TAG, "onTouch: left = " + event.getX()
                        + "top = " + event.getY()
                        + "right = " + event.getRawX()
                        + "bottom = " + event.getRawY());
                return false;
            }
        });

        int scaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        Log.i(TAG, "onCreate: scaledTouchSlop:" + scaledTouchSlop);
    }
}
