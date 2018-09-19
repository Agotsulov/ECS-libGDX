package com.byzilio.engine.core;

public interface Input{

    // TODO: Хоть и универсально ,но не удобно переписать. Еще и плохо работает с libGDX InputProcessor из асинхронности

    void setKey(String keycode, int value);

    void setKeyDown(String keycode);

    void setKeyUp(String keycode);

    int getKey(String keycode);

    boolean keyDown(String keycode);

    boolean keyUp(String keycode);

    void reset();
}
