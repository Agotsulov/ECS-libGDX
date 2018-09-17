package com.byzilio.engine.core;

public interface Input{

    void setKey(String keycode, int value);

    void setKeyDown(String keycode);

    void setKeyUp(String keycode);

    int getKey(String keycode);

    boolean keyDown(String keycode);

    boolean keyUp(String keycode);

    void reset();
}
