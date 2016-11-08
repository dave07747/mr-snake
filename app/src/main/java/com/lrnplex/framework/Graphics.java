package com.lrnplex.framework;


/**
 * Created by David on 6/23/2016.
 */
public interface Graphics {
    enum PixmapFormat{
        ARGB8888, ARGB4444, RGB565
    }

    Pixmap newPixmap(String fileName, PixmapFormat format);

    void clear(int color);

    void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);

    void drawPixmap(Pixmap pixmap, int x, int y);

    void drawLine(int x, int y, int x2, int y2, int color);

    int getWidth();

    int getHeight();
}
