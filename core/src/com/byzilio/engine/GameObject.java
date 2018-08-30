package com.byzilio.engine;

import com.badlogic.gdx.Gdx;
public abstract class GameObject {

    protected String name = "GameObject";

    protected Engine engine = null;

    protected GameObject gameObject = null;

    private boolean debug = true;

    public void create(Engine engine) {
        this.engine = engine;
    }

    public void create(Engine engine, GameObject gameObject) {
        create(engine);
        this.gameObject = gameObject;
    }

    public abstract void dispose();

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
