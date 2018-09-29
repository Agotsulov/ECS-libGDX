package com.byzilio.common.other;

import com.badlogic.gdx.math.Vector2;

public class libGDXVector implements Vector {

    private Vector2 vector2;

    public libGDXVector() {
        vector2 = new Vector2();
    }

    @Override
    public float getX() {
        return vector2.x;
    }

    @Override
    public float getY() {
        return vector2.y;
    }

    @Override
    public void setX(float x) {
        vector2.x = x;
    }

    @Override
    public void setY(float y) {
        vector2.y = y;
    }

    @Override
    public Vector add(float x, float y) {
        vector2.add(x, y);
        return this;
    }

    @Override
    public Vector add(Vector v) {
        add(v.getX(), v.getY());
        return this;
    }

    @Override
    public float angle() {
        return vector2.angle();
    }

    @Override
    public float dot(float ox, float oy) {
        return vector2.dot(ox, oy);
    }

    @Override
    public float dst(float x, float y) {
        return vector2.dst(x, y);
    }

    @Override
    public boolean isZero() {
        return vector2.isZero();
    }

    @Override
    public float len() {
        return vector2.len2();
    }

    @Override
    public Vector limit(float limit) {
        vector2.limit(limit);
        return this;
    }

    @Override
    public Vector nor() {
        vector2.nor();
        return this;
    }

    @Override
    public Vector rotate(float degrees) {
        vector2.rotate(degrees);
        return this;
    }

    @Override
    public Vector scl(float scalar) {
        vector2.scl(scalar);
        return this;
    }

    @Override
    public Vector scl(float x, float y) {
        vector2.scl(x, y);
        return this;
    }

    @Override
    public Vector scl(Vector v) {
        scl(v.getX(), v.getY());
        return this;
    }

    @Override
    public Vector set(float x, float y) {
        setX(x);
        setY(y);
        return this;
    }

    @Override
    public Vector set(Vector v) {
        set(v.getX(), v.getY());
        return this;
    }

    @Override
    public Vector setAngle(float degrees) {
        setAngle(degrees);
        return this;
    }

    @Override
    public Vector setLength(float length) {
        vector2.setLength(length);
        return this;
    }

    @Override
    public Vector setZero() {
        vector2.setZero();
        return this;
    }

    @Override
    public Vector sub(float x, float y) {
        vector2.sub(x, y);
        return this;
    }

    @Override
    public Vector sub(Vector v) {
        sub(v.getX(), v.getY());
        return this;
    }
}
