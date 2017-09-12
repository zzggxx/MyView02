package com.u9time.clicview.click;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by will on 2017/9/12.
 */

public class ClickView extends View {
    private int startRawX;
    private int startRawY;
    private ViewClick mViewClick;
    private OnClickListener mListener;

    public ClickView(Context context) {
        this(context, null);
    }

    public ClickView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    // TODO: 2017/9/12 点击事件定义不完美!!!!!!!!!!!!!!!!!
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startRawX = rawX;
                startRawY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (x + getLeft() < getRight() && y + getTop() < getBottom()) {
                    if (mListener != null)
                        mListener.onClick(this);
                    if (mViewClick != null)
                        mViewClick.onClick(rawX - startRawX, rawY - startRawY);
                }
                break;
        }
        return true;
    }

    public interface ViewClick {
        void onClick(int offX, int offY);
    }

    public void setViewCick(ViewClick viewCick) {
        this.mViewClick = viewCick;
    }

    /*-------系统本身含有的监听,我们在自定义的时候是不能传值的,只能调用----------*/
    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mListener = l;
    }

}
