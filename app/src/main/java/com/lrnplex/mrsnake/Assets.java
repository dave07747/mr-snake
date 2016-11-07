package com.lrnplex.mrsnake;

import com.lrnplex.framework.Pixmap;
import com.lrnplex.framework.Sound;

public class Assets {

    /**
     * Add whatever assets needed, just a baseline here
     */

    private static Pixmap numbers;
    private static Pixmap ready;
    private static Pixmap pause;
    private static Pixmap gameOver;
    private static Pixmap soundOn;
    private static Pixmap soundOff;
    private static Pixmap Title;
    private static Pixmap Start;
    private static Pixmap Score;
    private static Pixmap themeScreen;
    private static Pixmap resume;
    private static Pixmap quit;
    private static Pixmap ball;

    private static Sound fall;
    private static Sound click;

    public static Pixmap getBall() {
        return ball;
    }

    public static void setBall(Pixmap ball) {
        Assets.ball = ball;
    }

    public static Pixmap getResume() {
        return resume;
    }

    public static void setResume(Pixmap resume) {
        Assets.resume = resume;
    }

    public static Pixmap getQuit() {
        return quit;
    }

    public static void setQuit(Pixmap quit) {
        Assets.quit = quit;
    }

    public static Pixmap getScore() {
        return Score;
    }

    public static void setScore(Pixmap score) {
        Score = score;
    }

    public static Pixmap getThemeScreen() {
        return themeScreen;
    }

    public static void setThemeScreen(Pixmap themeScreen) {
        Assets.themeScreen = themeScreen;
    }

    public static Pixmap getStart() {
        return Start;
    }

    public static void setStart(Pixmap start) {
        Start = start;
    }

    public static Pixmap getTitle() {
        return Title;
    }

    public static void setTitle(Pixmap title) {
        Title = title;
    }

    public static Pixmap getSoundOn() {
        return soundOn;
    }

    public static void setSoundOn(Pixmap soundOn) {
        Assets.soundOn = soundOn;
    }

    public static Pixmap getSoundOff() {
        return soundOff;
    }

    public static void setSoundOff(Pixmap soundOff) {
        Assets.soundOff = soundOff;
    }

    public static Sound getClick() {
        return click;
    }

    public static void setClick(Sound click) {
        Assets.click = click;
    }

    public static Pixmap getNumbers() {
        return numbers;
    }

    public static void setNumbers(Pixmap numbers) {
        Assets.numbers = numbers;
    }

    public static Pixmap getReady() {
        return ready;
    }

    public static void setReady(Pixmap ready) {
        Assets.ready = ready;
    }

    public static Pixmap getPause() {
        return pause;
    }

    public static void setPause(Pixmap pause) {
        Assets.pause = pause;
    }

    public static Pixmap getGameOver() {
        return gameOver;
    }

    public static void setGameOver(Pixmap gameOver) {
        Assets.gameOver = gameOver;
    }

    public static Sound getFall() {
        return fall;
    }

    public static void setFall(Sound fall) {
        Assets.fall = fall;
    }
}
