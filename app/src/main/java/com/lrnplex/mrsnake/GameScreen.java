package com.lrnplex.mrsnake;


import android.util.Log;

import com.lrnplex.framework.Game;
import com.lrnplex.framework.Graphics;
import com.lrnplex.framework.Input.TouchEvent;
import com.lrnplex.framework.Music;
import com.lrnplex.framework.Screen;

import java.util.List;


public class GameScreen extends Screen {
    enum GameState{
        Ready,
        Running,
        Paused,
        GameOver
    }

    GameState state = GameState.Ready;
    World world;
    int oldScore = 0;
    String score = "0";
    Music music;


    public GameScreen(Game game){
        super(game);
        world = new World();
        // music = game.getMusic();
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        int len = touchEvents.size();



        for(int i = 0; i < len; ++i){
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP){
                if(event.x > 1200 && event.y < 80){
                    if(Settings.soundEnabled)
                        Assets.getClick().play(1);
                    state = GameState.Paused;
                    //Log.d("GameScreen", "updateRunning: State paused");
                    return;
                }
            }
            if(event.type == TouchEvent.TOUCH_DOWN){

                /**
                 * Detect half the screen and then make turn
                 */
            }
        }

        world.update(deltaTime);
        if(world.gameOver){
            if(Settings.soundEnabled)
                Assets.getFall().play(1);
            state = GameState.GameOver;
        }

        if(oldScore != world.score){
            oldScore = world.score;
            score = "" + oldScore;
            /**
             * Possibly insert land sound for ball?
             */
        }
    }

    private void updatePaused(List<TouchEvent> touchEvents){
        int len = touchEvents.size();
        for(int i = 0; i < len; ++i){
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP){
                if(event.x > 340 && event.x <= 940){
                    if(event.y > 140 && event.y <= 340){
                        if(Settings.soundEnabled)
                            Assets.getClick().play(1);
                        state = GameState.Running;
                        return;
                    }
                }
                if(event.x > 470 && event.x <= 800){
                    if(event.y > 350 && event.y <= 550){
                        if(Settings.soundEnabled)
                            Assets.getClick().play(1);
                        game.setScreen(new MainMenuScreen(game));
                        return;
                    }
                }
            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents){
        int len = touchEvents.size();
        for(int i = 0; i < len; ++i){
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP){
                if(inBounds(event, 530, 360, 215, 215)){ // coordinates of play button
                    Log.d("Update: ", "Touched start");
                    game.setScreen(new GameScreen(game));
                    if(Settings.soundEnabled)
                        Assets.getClick().play(1);
                    return;
                }

                if(inBounds(event, 430, 660, 120, 120)){ // coordinates of sound enable
                    Log.d("Update: ", "Toggled Sound");
                    Settings.soundEnabled = !Settings.soundEnabled;
                    if(Settings.soundEnabled) {
                        Assets.getClick().play(1);
                        music.play();
                    }
                    else {
                        music.pause();
                    }
                }

                if(inBounds(event, 580, 660, 120, 120)){ // coordinates of scoring
                    // instruction for score screen goes here
                    Log.d("Update: ", "Touched scoring");
                    if(Settings.soundEnabled)
                        Assets.getClick().play(1);
                    return;
                }

                if(inBounds(event, 740, 660, 120, 120)){ // coordinates for theme
                    Log.d("Update: ", "Touched theme");
                    game.setScreen(new ThemeScreen(game));
                    if(Settings.soundEnabled)
                        Assets.getClick().play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime){
        Graphics g = game.getGraphics();

        g.clear(0x808090); // Change this to the active background later on
        drawWorld(world);
        if(state == GameState.Ready)
            drawReadyUI();
        if(state == GameState.Running)
            drawRunningUI();
        if(state == GameState.Paused)
            drawPausedUI();
        if(state == GameState.GameOver)
            drawGameOverUI();

    }

    private void drawWorld(World world){
        Graphics g = game.getGraphics();

    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.getReady(), 300, 20);
    }

    private void drawRunningUI(){
        Graphics g = game.getGraphics();

        drawText(g, score, g.getWidth() /2 - score.length()*20 / 2, g.getHeight() - 700); // Adjust coordinates for score to center

        g.drawPixmap(Assets.getPause(), 1200, 5); // pause button
    }

    private void drawPausedUI(){
        Graphics g = game.getGraphics();
        // Log.d("DrawUI", "drawPausedUI: Drawing pause screen");

        g.drawPixmap(Assets.getResume(), 340, 140);
        g.drawPixmap(Assets.getQuit(), 470, 350);
    }

    private void drawGameOverUI(){
        Graphics g = game.getGraphics();

        drawText(g, score, g.getWidth() /2 - score.length()*20 / 2, g.getHeight() - 700); // Adjust coordinates for score to center

        g.drawPixmap(Assets.getGameOver(), 240, 20);    //Game over text
        g.drawPixmap(Assets.getStart() , 530, 360);     //Start Button
        if(Settings.soundEnabled)
            g.drawPixmap(Assets.getSoundOn(), 430, 660);//Sound Enabled
        else
            g.drawPixmap(Assets.getSoundOff(), 430, 660);//Sound disabled
        g.drawPixmap(Assets.getScore(), 580, 660);       //Score Button
        g.drawPixmap(Assets.getThemeScreen(), 740, 660); //Theme Button
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

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height){
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height -1)
            return true;
        else
            return false;
    }

    @Override
    public void pause() {
        if(state == GameState.Running)
            state = GameState.Paused;
        if(world.gameOver && Settings.highscore < world.score){
            Settings.highscore = world.score;
            game.save();
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
