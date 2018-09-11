package com.byzilio.engine.core;

import com.badlogic.gdx.Screen;
import com.byzilio.engine.Scene;
import com.byzilio.engine.System;

public interface IEngine extends Screen,Container<System> {

    void changeScene(Scene scene);

}
