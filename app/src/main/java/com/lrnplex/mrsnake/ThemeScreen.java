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
            }
        }
    }

    @Override
    public void present(float deltaTime){
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.getBackground(), 0, 0);
        g.drawPixmap(Assets.getBackArrow(), 10, 10);

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
}
