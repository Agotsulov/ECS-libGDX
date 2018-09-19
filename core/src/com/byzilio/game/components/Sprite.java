package com.byzilio.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.game.components.core.Renderable;

public class Sprite extends Renderable {

    private Texture texture;

    private float w;
    private float h;

    private float offsetX;
    private float offsetY;

    public Sprite(int layer,Texture texture, float w, float h) {
        super(layer);
        setName("Sprite");
        this.texture = texture;
        this.w = w;
        this.h = h;
        setDebug(false);
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    @Override
    public void draw(float x, float y, float scale, SpriteBatch batch) {
        log("DRAW " + x + " " + y + " " + scale + " " + batch);
        batch.draw(texture, x, y, w * scale,  h * scale);
        //batch.draw(new Texture("badlogic.jpg"), 0, 0);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
