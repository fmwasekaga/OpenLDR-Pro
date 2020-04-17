package com.kagaconnect.core.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

public class GridViewEx extends GridView {
    public GridViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return false;
        //return super.dispatchTouchEvent(event);
    }
}
