package com.chengang.hobby.widget;


import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 继承自SwipeRefreshLayout下拉刷新类
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-10
 */
public class CBSwipeRefreshLayout extends SwipeRefreshLayout{

    public CBSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CBSwipeRefreshLayout(Context context, AttributeSet attrs){
        super(context ,attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(!isEnabled()){
           return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(!isEnabled()){
            return false;
        }
        return super.onTouchEvent(ev);
    }
}
