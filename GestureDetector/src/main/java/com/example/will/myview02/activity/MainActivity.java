package com.example.will.myview02.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.will.myview02.R;
import com.example.will.myview02.click.ClickView;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        1,测试封装
//        GestureDetector();

//        2,自定义点击事件
        ClickView clickView = new ClickView(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(500, 500);
//        clickView.setLayoutParams(layoutParams);
        clickView.setBackgroundColor(Color.parseColor("#00ff00"));
        this.addContentView(clickView,layoutParams);
        clickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "验证点击事件,调用了系统的点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        clickView.setViewCick(new ClickView.ViewClick() {
            @Override
            public void onClick(int offX, int offY) {
                Log.i(getClass().getName(), "onClick-----offX" + offX + ",offY" + offY);
                Toast.makeText(MainActivity.this, "验证点击事件,调用了系统自定义的点击事件", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    private void GestureDetector() {
//        mGestureDetector = new GestureDetector(this, new MyGestureDetector());
//
//        findViewById(R.id.btn).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                mGestureDetector.onTouchEvent(event);
////                return false;
//                /**
//                 * 返回true就是为了接收到所有的事件,关于onTouch和onclick的问题参见郭林博客???
//                 */
//                return true;
//            }
//        });
//    }
}
