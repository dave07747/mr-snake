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



        Assets.setClick(game.getAudio().newSound("click.ogg"));
        Assets.setFall(game.getAudio().newSound("fall.mp3"));
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
