package com.byzilio.common.components.core;

import com.byzilio.common.components.Position;
import com.byzilio.engine.Component;

public abstract class Collider extends Component {

    private boolean isTrigger = false;

    public Collider(boolean isTrigger) {
        this.isTrigger = isTrigger;
    }

    public boolean isTrigger() {
        return isTrigger;
    }

    public void setTrigger(boolean trigger) {
        isTrigger = trigger;
    }

    public abstract boolean check(Position position, Collider other);

}
