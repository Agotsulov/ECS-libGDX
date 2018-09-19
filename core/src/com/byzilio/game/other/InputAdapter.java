package com.byzilio.game.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.byzilio.engine.core.Input;

public class InputAdapter implements InputProcessor {

    private Input input;

    //Это не работет 60 раз в секунду.

    public InputAdapter(Input input) {
        this.input = input;
    }

    @Override
    public boolean keyDown(int keycode) {
        Gdx.app.log("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIISnputAdapter: " ,"keyDown = " + com.badlogic.gdx.Input.Keys.toString(keycode));
        input.setKeyDown(com.badlogic.gdx.Input.Keys.toString(keycode));
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        Gdx.app.log("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIISnputAdapter: " ,"keyUp = " + com.badlogic.gdx.Input.Keys.toString(keycode));
        input.setKeyUp(com.badlogic.gdx.Input.Keys.toString(keycode));
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        Gdx.app.log("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIISnputAdapter: " ,"keyTyped = " + character);
        input.setKey(String.valueOf(character), -2);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        input.setKeyDown("touchDownX_" + pointer + "_" + button);
        input.setKeyDown("touchDownY_" + pointer + "_" + button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        input.setKeyDown("touchUpX_" + pointer + "_" + button);
        input.setKeyDown("touchUpY_" + pointer + "_" + button);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        input.setKey("Scrollec", amount);
        return true;
    }
}
