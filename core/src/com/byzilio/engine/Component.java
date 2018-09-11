package com.byzilio.engine;

public abstract class Component extends GameObject{

    protected GameObject gameObject;


    public GameObject getGameObject() {
        return gameObject;
    }
}
