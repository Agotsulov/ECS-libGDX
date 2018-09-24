package com.byzilio.game.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.byzilio.engine.core.Input;

public class InputAdapter implements InputProcessor {

    private Input input;

    //Это не работет 60 раз в секунду.
    //TODO: Правила записи в input хранить в конфиге.


    public InputAdapter(Input input) {
        this.input = input;
    }

    @Override
    public boolean keyDown(int keycode) {
        input.setKeyDown(com.badlogic.gdx.Input.Keys.toString(keycode));
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        input.setKeyUp(com.badlogic.gdx.Input.Keys.toString(keycode));
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        input.setKey(String.valueOf(Character.toUpperCase(character)), 2);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        input.setKey("touchX_" + pointer, screenX);
        input.setKey("touchY_" + pointer, Gdx.graphics.getHeight() - screenY);
        input.setKey("touchButton_" + pointer, button);

        return false;
}

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        input.setKey("touchX_" + pointer, -1);
        input.setKey("touchY_" + pointer, -1);
        input.setKey("touchButton_" + pointer, -1);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        input.setKey("touchX_" + pointer, screenX);
        input.setKey("touchY_" + pointer, Gdx.graphics.getHeight() - screenY);
        return true;
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
