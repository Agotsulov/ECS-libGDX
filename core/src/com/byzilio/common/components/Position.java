package com.byzilio.common.components;

import com.byzilio.engine.Component;

public class Position extends Component{

    //TODO: И вообще на векторах сделать бы.
    //TODO: Scale и поворот.

    private float x;
    private float y;

    public Position(float x, float y) {
        setName("Position");
        this.x = x;
        this.y = y;
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

    @Override
    public void dispose() {

    }
}
