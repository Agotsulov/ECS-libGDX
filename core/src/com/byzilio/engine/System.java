package com.byzilio.engine;

import com.byzilio.engine.core.GameCollection;

public abstract class System extends GameObject implements GameCollection<GameObject> {

    public void start() {}

    public abstract void preUpdate();

    public abstract void update();

    public abstract void postUpdate();


}
