package com.byzilio.common.components.сolliders;

import com.byzilio.common.components.Position;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.common.components.core.Collider;

public class BoxCollider extends Collider {

    private float width;
    private float height;
    private Position position;

    public BoxCollider(boolean isTrigger, float width, float height) {
        super(isTrigger);
        this.width = width;
        this.height = height;
    }

    @Override
    public void create(Engine engine, Entity entity) {
        super.create(engine, entity);
        position = (Position) entity.get(Position.class);
    }


    @Override
    public boolean check(Position position, Collider other) {
        if((position != null) && (other instanceof BoxCollider) ) {
            BoxCollider boxCollider = (BoxCollider) other;
            float x1 = this.position.getX();
            float x2 = position.getX();
            float y1 = this.position.getY();
            float y2 = position.getY();
            float w1 = this.width;
            float w2 = boxCollider.width;
            float h1 = this.height;
            float h2 = boxCollider.height;

            if (x1 > x2 && x1 < x2 + w2 && y1 > y2 && y1 < y2 + h2) {
                return true;
            }
            if (x1 + w1 > x2 && x1 + w1 < x2 + w2 && y1 > y2 && y1 < y2 + h2) {
                return true;
            }
            if (x1 > x2 && x1 < x2 + w2 && y1 + h1 > y2 && y1 + h1 < y2 + h2) {
                return true;
            }
            if (x1 + w1 > x2 && x1 + w1 < x2 + w2 && y1 + h1 > y2 && y1 + h1 < y2 + h2) {
                return true;
            }

            if (x1 > x2 && x1 < x2 + w2 && y2 > y1 && y2 < y1 + h1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void dispose() {

    }
}
