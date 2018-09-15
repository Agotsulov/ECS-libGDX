package com.byzilio.engine;

import com.badlogic.gdx.Gdx;
import com.byzilio.engine.core.Debugable;
import com.byzilio.engine.core.Engine;
import com.byzilio.engine.core.IGameObject;

public abstract class GameObject implements IGameObject, Debugable {

    protected String name = "GameObject";

    protected Engine engine = null;

    protected GameObject gameObject = null;

    private boolean debug = true;

    public void create(Engine engine, GameObject gameObject) {
        this.engine = engine;
        this.gameObject = gameObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void log(String massage) {
        if(debug)
            Gdx.app.log(name, massage);
    }
}
