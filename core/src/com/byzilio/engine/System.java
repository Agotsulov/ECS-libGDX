package com.byzilio.engine;

public abstract class System extends GameObject implements Container<GameObject> {

    public abstract void preUpdate();

    public abstract void update();

    public abstract void postUpdate();


}
