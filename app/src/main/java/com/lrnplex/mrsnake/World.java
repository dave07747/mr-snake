package com.lrnplex.mrsnake;


public class World {
    static final int WORLD_WIDTH = 160;
    static final int WORLD_HEIGHT = 90;
    static final int SCORE_INCREMENT = 1;
    static final float TICK_INITIAL = 0.5f;
    static final float TICK_DECREMENT = 0.05f;



    public boolean gameOver = false;
    public int score = 0;


    //boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    //Random random = new Random();
    float tickTime = 0;
    float tick = TICK_INITIAL;

    public World(){

    }

    public void update(float deltaTime){
        if(gameOver)
            return;

        tickTime += deltaTime;

        while(tickTime > tick){
            tickTime -= tick;


            if(score % 10 == 0 && tick - TICK_DECREMENT > 0)
                tick -= TICK_DECREMENT;
        }
    }
}
