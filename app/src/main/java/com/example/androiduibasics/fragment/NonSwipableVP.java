package com.example.androiduibasics.fragment;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipableVP extends ViewPager {

    private boolean enabled;

    public NonSwipableVP(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        enabled = false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(enabled)
        return super.onTouchEvent(ev);
        else return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(enabled)
        return super.onInterceptTouchEvent(ev);
        else return false;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
}
