package com.lrnplex.framework.impl;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.lrnplex.framework.Audio;
import com.lrnplex.framework.Music;
import com.lrnplex.framework.Sound;

import java.io.IOException;

/**
 * Created by David on 6/23/2016.
 */
public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

    public AndroidAudio(Activity activity){
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    public Music newMusic(String fileName){
        try{
            AssetFileDescriptor assetDescriptor = assets.openFd(fileName);
            return new AndroidMusic(assetDescriptor);
        } catch (IOException e){
            throw new RuntimeException("Couldn't load music '" + fileName + "'");
        }
    }

    public Sound newSound(String fileName){
        try{
            AssetFileDescriptor assetFileDescriptor = assets.openFd(fileName);
            int soundId = soundPool.load(assetFileDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        }catch (IOException e){
            throw new RuntimeException("Couldn't load sound '" + fileName + "'");
        }
    }
}
