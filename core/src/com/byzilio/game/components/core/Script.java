package com.byzilio.game.components.core;

import com.byzilio.engine.Component;
import com.byzilio.engine.Entity;

public abstract class Script extends Component {

    public abstract void start();

    public abstract void preUpdate();

    public abstract void update();

    public abstract void postUpdate();

    public void onClick() {}

    public void onTrigger(Entity other) {}

    public void onCollision(Entity other) {}

}
