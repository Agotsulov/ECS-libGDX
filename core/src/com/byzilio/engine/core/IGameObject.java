package com.byzilio.engine.core;

import com.byzilio.engine.Engine;
import com.byzilio.engine.GameObject;

public interface IGameObject {

    void create(Engine engine);

    void dispose();

    String getName();

    void setName(String name);

}
