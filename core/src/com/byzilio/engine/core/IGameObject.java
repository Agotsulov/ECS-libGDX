package com.byzilio.engine.core;

import com.byzilio.engine.core.Engine;
import com.byzilio.engine.GameObject;

public interface IGameObject {

    void create(Engine engine, GameObject gameObject);

    void dispose();

    String getName();

    void setName(String name);

}
