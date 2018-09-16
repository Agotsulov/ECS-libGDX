package com.byzilio.game.components;

import com.byzilio.engine.Component;

public abstract class Script extends Component {

    public abstract void start();

    public abstract void preUpdate();

    public abstract void update();

    public abstract void postUpdate();

}
