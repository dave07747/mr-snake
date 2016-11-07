package com.lrnplex.framework;

/**
 * Created by David on 6/23/2016.
 */

import com.lrnplex.framework.Graphics.PixmapFormat;
public interface Pixmap {
    int getWidth();

    int getHeight();

    PixmapFormat getFormat();

    void dispose();
}
