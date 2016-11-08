package com.lrnplex.mrsnake;

import com.lrnplex.framework.Game;
import com.lrnplex.framework.Graphics;
import com.lrnplex.framework.Screen;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game){
        super(game);
    }

    public void update(float deltaTime){
        Graphics g = game.getGraphics();
        /**
         * Load all the assets here
         */
        Assets.setSoundOn(g.newPixmap("soundOn.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setSoundOff(g.newPixmap("soundOff.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setTitle(g.newPixmap("Title.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setStart(g.newPixmap("Start.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setScore(g.newPixmap("Score.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setThemeScreen(g.newPixmap("themeScreen.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setPause(g.newPixmap("pause.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setQuit(g.newPixmap("Quit.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setResume(g.newPixmap("Resume.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setGameOver(g.newPixmap("GameOver.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setReady(g.newPixmap("Ready.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setNumbers(g.newPixmap("Numbers.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setBackArrow(g.newPixmap("backArrow.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setHighScore(g.newPixmap("highscore.png", Graphics.PixmapFormat.ARGB4444));

        Assets.setTheme1(g.newPixmap("headright1.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setTheme2(g.newPixmap("headright2.png", Graphics.PixmapFormat.ARGB4444));

        Assets.setFood1(g.newPixmap("food1.png", Graphics.PixmapFormat.ARGB4444));
        Assets.setFood2(g.newPixmap("food2.png", Graphics.PixmapFormat.ARGB4444));

        switch (Settings.theme){
            case 1:
                Assets.setHeadDown(g.newPixmap("headdown1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadUp(g.newPixmap("headup1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadLeft(g.newPixmap("headleft1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadRight(g.newPixmap("headright1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setTail(g.newPixmap("tail1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setBackground(g.newPixmap("background1.png", Graphics.PixmapFormat.ARGB4444));

                break;
            case 2:
                Assets.setHeadDown(g.newPixmap("headdown2.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadUp(g.newPixmap("headup2.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadLeft(g.newPixmap("headleft2.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadRight(g.newPixmap("headright2.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setTail(g.newPixmap("tail2.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setBackground(g.newPixmap("background2.png", Graphics.PixmapFormat.ARGB4444));

                break;
            default:
                Assets.setHeadDown(g.newPixmap("headdown1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadUp(g.newPixmap("headup1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadLeft(g.newPixmap("headleft1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setHeadRight(g.newPixmap("headright1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setTail(g.newPixmap("tail1.png", Graphics.PixmapFormat.ARGB4444));
                Assets.setBackground(g.newPixmap("background1.png", Graphics.PixmapFormat.ARGB4444));

        }

        Assets.setClick(game.getAudio().newSound("click.ogg"));
        Assets.setFall(game.getAudio().newSound("fall.mp3"));
        Assets.setEat(game.getAudio().newSound("eat.ogg"));
        //End loading assets

        game.setScreen(new MainMenuScreen(game));
    }

    public void present(float deltaTime){

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
