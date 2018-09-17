package com.byzilio.game.components;

import com.byzilio.engine.Component;

public class Rigidbody extends Component {

    private float ax = 0;
    private float ay = 0;

    private float ux = 0;
    private float uy = 0;

    private float gravity = 0;

    private float drag = 0;
    private float angularDrag = 0;

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

    @Override
    public void dispose() {

    }
}
