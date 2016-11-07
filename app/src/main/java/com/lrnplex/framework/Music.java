package com.lrnplex.framework;

/**
 * Created by David on 6/23/2016.
 */
public interface Music {
    void play();

    void stop();

    void pause();

    void setLooping(boolean looping);

    void setVolume(float volume);

    boolean isPlaying();

    boolean isLooping();

    void dispose();
}
