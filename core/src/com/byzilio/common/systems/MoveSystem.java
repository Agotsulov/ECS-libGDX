package com.byzilio.common.systems;

import com.byzilio.common.components.Position;
import com.byzilio.common.components.Rigidbody;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;

import java.util.ArrayList;
import java.util.List;

public class MoveSystem extends System {

    /*
        TODO: Столкновения.
        TODO: Учитывать гравитацию.
     */

    private class MoveObject{
        Rigidbody rb = null;
        Position position = null;

        public boolean isNull(){
            return (rb == null) || (position == null);
        }
    }

    private List<MoveObject> moveObjects;
    //private List<Pair<MoveObject, MoveObject>> collide;


    public MoveSystem() {
        setName("MoveSystem");
        setDebug(true);
    }

    @Override
    public void create(Engine engine) {
        super.create(engine);
        moveObjects = new ArrayList<MoveObject>();
    }

    @Override
    public void preUpdate() {
        log("preUpdate");
    }

    @Override
    public void update() {
        log("update");
        for(int i = 0; i < moveObjects.size(); i++){
            MoveObject curr = moveObjects.get(i);

            moveX(curr);

            curr.rb.setAx(0);

            moveY(curr);

            curr.rb.setAy(0);

        }
    }

    private void moveX(MoveObject curr){
        curr.rb.setUx(curr.rb.getUx() + curr.rb.getAx());

        if(curr.rb.getAx() == 0.0f){
            if ((curr.rb.getDrag() !=  0.0f) && (Math.abs(curr.rb.getUx()) < curr.rb.getDrag())) {
                curr.rb.setUx(0);
            } else if (curr.rb.getUx() > 0.0f){
                curr.rb.setUx(curr.rb.getUx() - curr.rb.getDrag());
            } else if (curr.rb.getUx() < 0.0f) {
                curr.rb.setUx(curr.rb.getUx() + curr.rb.getDrag());
            }
        }

        if(curr.rb.getUx() > curr.rb.getMaxUx())
            curr.rb.setUx(curr.rb.getMaxUx());

        if(curr.rb.getUx() < -curr.rb.getMaxUx())
            curr.rb.setUx(-curr.rb.getMaxUx());

        curr.position.setX(curr.position.getX() + curr.rb.getUx());

    }

    private void moveY(MoveObject curr){
        curr.rb.setUy(curr.rb.getUy() + curr.rb.getAy());
        if(curr.rb.getAy() == 0.0f){
            if ((curr.rb.getDrag() !=  0.0f) && (Math.abs(curr.rb.getUy()) < curr.rb.getDrag())) {
                curr.rb.setUy(0);
            } else if (curr.rb.getUy() > 0.0f) {
                curr.rb.setUy(curr.rb.getUy() - curr.rb.getDrag());
            } else if (curr.rb.getUy() < 0.0f) {
                curr.rb.setUy(curr.rb.getUy() + curr.rb.getDrag());
            }
        }

        if(curr.rb.getUy() > curr.rb.getMaxUy())
            curr.rb.setUy(curr.rb.getMaxUy());

        if(curr.rb.getUy() < -curr.rb.getMaxUy())
            curr.rb.setUy(-curr.rb.getMaxUy());

        curr.position.setY(curr.position.getY() + curr.rb.getUy());

    }

    @Override
    public void postUpdate() {
        log("postUpdate");
    }

    @Override
    public void add(GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            MoveObject moveObject = new MoveObject();

            moveObject.position = (Position) e.get(Position.class);
            moveObject.rb = (Rigidbody) e.get(Rigidbody.class);

            if(!moveObject.isNull()){
                moveObjects.add(moveObject);
            }
        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            MoveObject moveObject = new MoveObject();

            moveObject.position = (Position) e.get(Position.class);
            moveObject.rb = (Rigidbody) e.get(Rigidbody.class);

            if(!moveObject.isNull()){
                moveObjects.add(i, moveObject);
            }
        }
    }

    @Override
    public int size() {
        return moveObjects.size();
    }

    @Override
    public void clear() {
        moveObjects.clear();
    }

    @Override
    public boolean isEmpty() {
        return moveObjects.isEmpty();
    }

    @Override
    public GameObject remove(int i) {
        GameObject result = moveObjects.get(i).position;
        moveObjects.remove(i);
        return result;
    }

    @Override
    public boolean remove(Object o) {
        return moveObjects.remove(o);
    }


    @Override
    public void dispose() {
    }
}
