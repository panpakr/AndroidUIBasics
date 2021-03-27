package com.example.androiduibasics.fragment

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.MotionEvent

class NonSwipableViewPager(mContext :Context):ViewPager(mContext) {

    init {
       var enabled = false;
    }




    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }


    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(ev)
    }

}