package com.lrnplex.mrsnake;

import com.lrnplex.framework.Game;
import com.lrnplex.framework.Graphics;
import com.lrnplex.framework.Input;
import com.lrnplex.framework.Music;
import com.lrnplex.framework.Screen;

import java.util.List;

public class ThemeScreen extends Screen {
    private Music music = game.getMusic();
    public ThemeScreen(Game game){
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        Graphics g = game.getGraphics();

        int len = touchEvents.size();
        for (int i = 0; i < len; ++i) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (event.x < 115 && event.y < 90) {
                    if (Settings.soundEnabled)
                        Assets.getClick().play(1);
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
                if(inBounds(event, game.getGraphics().getWidth()/3, 350, 100, 100)){
                    Assets.setHeadDown(g.newPixmap("headdown1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setHeadUp(g.newPixmap("headup1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setHeadLeft(g.newPixmap("headleft1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setHeadRight(g.newPixmap("headright1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setTail(g.newPixmap("tail1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setBackground(g.newPixmap("background1.png", Graphics.PixmapFormat.ARGB4444));
                    game.save();
                }
                if(inBounds(event,2 * game.getGraphics().getWidth()/3, 350, 100, 100)){
                    Assets.setHeadDown(g.newPixmap("headdown2.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setHeadUp(g.newPixmap("headup2.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setHeadLeft(g.newPixmap("headleft2.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setHeadRight(g.newPixmap("headright2.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setTail(g.newPixmap("tail2.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setBackground(g.newPixmap("background2.png", Graphics.PixmapFormat.ARGB4444));
                    game.save();
                }
            }
        }
    }

    @Override
    public void present(float deltaTime){
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.getBackground(), 0, 0);
        g.drawPixmap(Assets.getBackArrow(), 10, 10);

        g.drawPixmap(Assets.getTheme1(), g.getWidth()/3, 350);
        g.drawPixmap(Assets.getTheme2(), 2 * g.getWidth()/3, 350);

    }

    @Override
    public void pause() {
        music.pause();
    }

    @Override
    public void resume() {
        if(Settings.soundEnabled)
            music.play();
    }

    @Override
    public void dispose() {
        music.stop();
        music.dispose();
    }

    private boolean inBounds(Input.TouchEvent event, int x, int y, int width, int height){
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height -1)
            return true;
        else
            return false;
    }
}
