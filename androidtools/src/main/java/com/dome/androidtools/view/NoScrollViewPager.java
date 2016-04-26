package com.dome.androidtools.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 无滑动效果的ViewPager
 * <p>
 * Created by 禄骥
 * 2016/4/7.
 */
public class NoScrollViewPager extends ViewPager {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private boolean isScrollEnable = false;

    // ===========================================================
    // Constructors
    // ===========================================================
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public void setScrollEnable(boolean scrollEnable) {
        isScrollEnable = scrollEnable;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScrollEnable && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScrollEnable && super.onInterceptTouchEvent(ev);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
