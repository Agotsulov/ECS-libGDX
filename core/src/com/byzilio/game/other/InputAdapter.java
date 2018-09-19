package com.byzilio.game.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.byzilio.engine.core.Input;

public class InputAdapter implements InputProcessor {

    private Input input;

    public InputAdapter(Input input) {
        this.input = input;
    }

    @Override
    public boolean keyDown(int keycode) {
        input.setKeyDown(String.valueOf(keycode));
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        input.setKeyUp(String.valueOf(keycode));
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        input.setKey(String.valueOf(character), 2

        );
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
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
        return false;
    }
}
