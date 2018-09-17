package com.byzilio.engine.core;

import com.byzilio.engine.Engine;

public interface IGameObject {

    void create(Engine engine);

    void dispose();

    String getName();

    void setName(String name);

}
