package com.byzilio.engine;

public interface IGameObject {

    void create(Engine engine, GameObject gameObject);

    void dispose();

    String getName();

    void setName(String name);

}
