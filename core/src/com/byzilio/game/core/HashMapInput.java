package com.byzilio.game.core;

import com.byzilio.engine.core.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapInput implements Input {



    private Map<String, Integer> keys;

    public HashMapInput() {
        keys = new HashMap<String, Integer>();
    }


    @Override
    public void setKeyDown(String keycode) {
        keys.put(keycode, 1);
    }

    @Override
    public void setKeyUp(String keycode) {
        keys.put(keycode, 0);
    }

    @Override
    public int getKey(String keycode) {
        if(keys.get(keycode) != null )
            return keys.get(keycode);
        else
            return 0;
    }

    @Override
    public boolean keyDown(String keycode) {
        return keys.get(keycode) != null && keys.get(keycode) > 0;
    }

    @Override
    public boolean keyUp(String keycode) {
        return keys.get(keycode) != null && keys.get(keycode) < 0;
    }

    @Override
    public void setKey(String keycode, int value) {
        keys.put(keycode, value);
    }

    @Override
    public void reset() {
        //keys.clear();
    }
}
