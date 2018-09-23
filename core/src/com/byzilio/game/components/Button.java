package com.byzilio.game.components;

import com.byzilio.engine.Component;

public class Button extends Component {

    private float w;
    private float h;

    private float offsetX;
    private float offsetY;

    public Button(float w, float h) {
        this.w = w;
        this.h = h;
        offsetX = 0;
        offsetY = 0;
    }

    public Button(float w, float h, float offsetX, float offsetY) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
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
    public void dispose() {

    }
}
