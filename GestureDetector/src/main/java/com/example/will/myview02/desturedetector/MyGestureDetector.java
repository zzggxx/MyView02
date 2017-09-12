package com.example.will.myview02.desturedetector;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * 主要是为了测试其封装的成熟事件所对应的准确的事件点.更好的学习可以自己参见源码进行定义
 * 注意是继承并且是SimpleOnGestureListener,一般都是类似的方式
 */
public class MyGestureDetector extends GestureDetector.SimpleOnGestureListener{
    public MyGestureDetector() {
        super();
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.i(getClass().getName(), "onDoubleTap-----" + Utils.getActionName(e.getAction()));
        return super.onDoubleTap(e);
    }

    /*双击事件中间发生的回调事件*/
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.i(getClass().getName(), "onDoubleTapEvent-----" + Utils.getActionName(e.getAction()));
        return super.onDoubleTapEvent(e);
    }

    @Override
    public boolean onContextClick(MotionEvent e) {
        return super.onContextClick(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.i(getClass().getName(), "onDown-----" + Utils.getActionName(e.getAction()));
        return false;
    }

    /*longpress的时候down完事之后调用*/
    @Override
    public void onShowPress(MotionEvent e) {
        Log.i(getClass().getName(), "onShowPress-----" + Utils.getActionName(e.getAction()));

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i(getClass().getName(), "onSingleTapUp-----" + Utils.getActionName(e.getAction()));
        return false;
    }

    /*不一定有up事件*/
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i(getClass().getName(),
                "onScroll-----" + Utils.getActionName(e2.getAction()) + ",(" + e1.getX() + "," + e1.getY() + ") ,("
                        + e2.getX() + "," + e2.getY() + ")");
        return false;
    }

    /*产生长按的时候,后续将滑动将不会产生滑动以及其他的事件序列了*/
    @Override
    public void onLongPress(MotionEvent e) {
        Log.i(getClass().getName(), "onLongPress-----" + Utils.getActionName(e.getAction()));

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(getClass().getName(),
                "onScroll-----" + Utils.getActionName(e2.getAction()) + ",(" + e1.getX() + "," + e1.getY() + ") ,("
                        + e2.getX() + "," + e2.getY() + ")");
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i(getClass().getName(), "onSingleTapConfirmed-----" + Utils.getActionName(e.getAction()));
        return super.onSingleTapConfirmed(e);
    }
}
