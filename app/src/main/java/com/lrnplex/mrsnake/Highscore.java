package com.lrnplex.mrsnake;

import com.lrnplex.framework.Game;
import com.lrnplex.framework.Graphics;
import com.lrnplex.framework.Screen;
import com.lrnplex.framework.Input.TouchEvent;

import java.util.List;

public class Highscore extends Screen{

    public Highscore(Game game){
        super(game);
    }

    @Override
    public void update(float deltaTime){
        List<TouchEvent> touchEvents= game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; ++i){
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP){
                if(event.x < 115 && event.y < 90){
                    if(Settings.soundEnabled)
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
        g.drawPixmap(Assets.getHighScore(), 450, 10);

        drawText(g, String.valueOf(Settings.highscore), 580, 360);
    }

    private void drawText(Graphics g, String line, int x, int y){
        int len = line.length();
        for(int i = 0; i < len; ++i){
            char character = line.charAt(i);

            if(character == ' '){
                x += 100;
                continue;
            }

            int srcX;
            int srcWidth;
            if(character == '.'){
                srcX = 1000;
                srcWidth = 50;
            }
            else{
                srcX = (character - '0') * 100;
                srcWidth = 100;
            }

            g.drawPixmap(Assets.getNumbers(), x, y, srcX, 0, srcWidth, 100);
            x += srcWidth;
        }
    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }

    @Override
    public void dispose(){

    }

}
