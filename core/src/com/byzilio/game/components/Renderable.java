package com.byzilio.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.engine.Component;

public abstract class Renderable extends Component {

    private int layer;

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

}
