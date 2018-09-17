package com.byzilio.game.systems;

import com.badlogic.gdx.Gdx;
import com.byzilio.engine.Engine;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.engine.core.Input;
import com.byzilio.game.other.InputAdapter;

public class InputSystem extends System {

    private Input input;

    public InputSystem() {
        setName("InputSystem");
        setDebug(false);
    }

    /*
        TODO: Подумать и добавить сюда нажатие кнопок(вызова onClick в Script) и т.п.
     */

    @Override
    public void start() {
        log("start");
        input = engine.input;
        Gdx.input.setInputProcessor(new InputAdapter(input));
    }

    @Override
    public void preUpdate() {

    }

    @Override
    public void update() {

    }

    @Override
    public void postUpdate() {
        log("postUpdate");
        input.reset();
    }

    @Override
    public void add(GameObject gameObject) {

    }

    @Override
    public void add(int i, GameObject gameObject) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public GameObject remove(int i) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void dispose() {

    }
}
