package com.byzilio.engine;

public abstract class Component extends GameObject{

    protected GameObject gameObject;


    public void create(Engine engine, GameObject gameObject) {
        super.create(engine);
        this.gameObject = gameObject;
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
