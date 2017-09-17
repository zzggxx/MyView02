package com.u9time.clicview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.u9time.clicview.R;
import com.u9time.clicview.click.ClickView;
import com.u9time.clicview.desturedetector.MyGestureDetector;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;
    private ClickView mClickView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClickView = (ClickView) findViewById(R.id.click_view);

        mGestureDetector = new GestureDetector(this, new MyGestureDetector());

//        1，即使是自定义的view也是可以使用系统定义好的手势的,very good!perfect
        mClickView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mGestureDetector.onTouchEvent(event);
                return true;
            }
        });

//        2,自己定义的事件,比较垃圾,还是系统的好啊
        mClickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "验证点击事件,调用了系统的点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        mClickView.setViewCick(new ClickView.ViewClick() {
            @Override
            public void onClick(int offX, int offY) {
                Log.i(getClass().getName(), "onClick-----offX" + offX + ",offY" + offY);
                Toast.makeText(MainActivity.this, "验证点击事件,调用了系统自定义的点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
