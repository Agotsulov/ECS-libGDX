package com.byzilio.common.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.common.components.core.Renderable;

public class Button extends Renderable {

    private float x;
    private float y;

    private float w;
    private float h;

    private Texture texture;

    public Button(int layer, float x, float y, float w, float h, String filename) {
        super(layer);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.texture = new Texture(filename);
        setGUI(true);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
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

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    @Override
    public void draw(float x, float y, float scale, SpriteBatch batch) {
        batch.draw(texture, this.x, this.y, w * scale, h * scale);
    }
}
