package com.lrnplex.framework.impl;

import android.view.View;

import com.lrnplex.framework.Input;

import java.util.List;

/**
 * Created by David on 7/2/2016.
 */
public interface TouchHandler extends View.OnTouchListener {
    boolean isTouchDown(int pointer);

    int getTouchX(int pointer);

    int getTouchY(int pointer);

    List<Input.TouchEvent>getTouchEvents();
}
