package com.byzilio.game.components;

import com.byzilio.engine.Component;

public class Rigidbody extends Component {

    // TODO: Переписать на векторах.
    // TODO: Вес.

    private float ax = 0;
    private float ay = 0;

    private float ux = 0;
    private float uy = 0;

    private float maxUx = 100;
    private float maxUy = 100;

    private float gravity = 0;

    private float drag = 0;
    private float angularDrag = 0;

    public Rigidbody(float ax, float ay, float ux, float uy, float maxUx, float maxUy, float gravity, float drag, float angularDrag) {
        this.ax = ax;
        this.ay = ay;
        this.ux = ux;
        this.uy = uy;
        this.maxUx = maxUx;
        this.maxUy = maxUy;
        this.gravity = gravity;
        this.drag = drag;
        this.angularDrag = angularDrag;
        setName("Rigidbody");
    }

    public float getAx() {
        return ax;
    }

    public void setAx(float ax) {
        this.ax = ax;
    }

    public float getAy() {
        return ay;
    }

    public void setAy(float ay) {
        this.ay = ay;
    }

    public float getUx() {
        return ux;
    }

    public void setUx(float ux) {
        this.ux = ux;
    }

    public float getUy() {
        return uy;
    }

    public void setUy(float uy) {
        this.uy = uy;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getDrag() {
        return drag;
    }

    public void setDrag(float drag) {
        this.drag = drag;
    }

    public float getAngularDrag() {
        return angularDrag;
    }

    public void setAngularDrag(float angularDrag) {
        this.angularDrag = angularDrag;
    }

    public float getMaxUx() {
        return maxUx;
    }

    public void setMaxUx(float maxUx) {
        this.maxUx = maxUx;
    }

    public float getMaxUy() {
        return maxUy;
    }

    public void setMaxUy(float maxUy) {
        this.maxUy = maxUy;
    }

    @Override
    public void dispose() {

    }
}
