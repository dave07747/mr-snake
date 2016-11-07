package com.lrnplex.framework;

/**
 * Created by David on 6/23/2016.
 */
public interface Game {
    Input getInput();

    FileIO getFileIO();

    Graphics getGraphics();

    Audio getAudio();

    Music getMusic();

    void setScreen(Screen screen);

    Screen getCurrentScreen();

    Screen getStartScreen();

    void save();

    void load();
}
