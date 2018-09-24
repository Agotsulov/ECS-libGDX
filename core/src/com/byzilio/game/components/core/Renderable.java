package com.byzilio.game.components.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.engine.Component;

public abstract class Renderable extends Component {

    protected int layer = 0;
    protected boolean onGUI = false;

    public Renderable(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public abstract void draw(float x, float y, float scale, SpriteBatch batch);

    public boolean onGUI() {
        return onGUI;
    }

    public void setGUI(boolean onGUI) {
        this.onGUI = onGUI;
    }

}
