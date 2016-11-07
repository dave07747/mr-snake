package com.lrnplex.mrsnake;

/**
 * Created by dave0 on 11/2/2016.
 */


import com.lrnplex.framework.Screen;
import com.lrnplex.framework.impl.AndroidGame;

public class MainActivity extends AndroidGame {

    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
