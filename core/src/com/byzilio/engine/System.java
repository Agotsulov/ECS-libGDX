package com.byzilio.engine;

import com.byzilio.engine.core.Container;

public abstract class System extends GameObject implements Container<GameObject> {

    public abstract void preUpdate();

    public abstract void update();

    public abstract void postUpdate();


}
