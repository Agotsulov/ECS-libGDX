package com.byzilio.common.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.common.components.core.Renderable;

public class Sprite extends Renderable {

    private Texture texture;

    private float w;
    private float h;

    private float offsetX;
    private float offsetY;

    public Sprite(int layer, Texture texture, float w, float h) {
        super(layer);
        setName("Sprite");
        this.texture = texture;
        this.w = w;
        this.h = h;
        offsetX = 0;
        offsetY = 0;
        onGUI = false;
        setDebug(false);
    }

    public Sprite(int layer, Texture texture, float w, float h, float offsetX, float offsetY) {
        super(layer);
        setName("Sprite");
        this.texture = texture;
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        onGUI = false;
        setDebug(false);
    }

    public Sprite(int layer, String texture, float w, float h) {
        super(layer);
        setName("Sprite");
        this.texture = new Texture(texture);
        this.w = w;
        this.h = h;
        offsetX = 0;
        offsetY = 0;
        onGUI = false;
        setDebug(false);
    }

    public Sprite(int layer, String texture, float w, float h, float offsetX, float offsetY) {
        super(layer);
        setName("Sprite");
        this.texture = new Texture(texture);
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        onGUI = false;
        setDebug(false);
    }

    public Sprite(int layer, Texture texture, float w, float h, float offsetX, float offsetY, boolean onGUI) {
        super(layer);
        setName("Sprite");
        this.texture = texture;
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.onGUI = onGUI;
        setDebug(false);
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
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

    public float getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    @Override
    public void draw(float x, float y, float scale, SpriteBatch batch) {
        log("DRAW " + x + " " + y + " " + scale + " " + batch);
        batch.draw(texture, x + offsetX, y + offsetY, w * scale,  h * scale);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
