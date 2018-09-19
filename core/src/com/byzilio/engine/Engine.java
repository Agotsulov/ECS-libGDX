package com.byzilio.engine;

import com.badlogic.gdx.Screen;
import com.byzilio.engine.core.Container;
import com.byzilio.engine.core.Input;
import com.byzilio.game.components.core.Time;

public abstract class Engine implements Screen,Container<System> {

    public Input input;

    public Engine(Input input) {
        this.input = input;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public abstract float getDeltaTime();

    public abstract void changeScene(Scene scene);

    public abstract Scene getScene();

}

