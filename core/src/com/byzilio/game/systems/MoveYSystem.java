package com.byzilio.game.systems;

import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.game.components.Position;
import com.byzilio.game.components.Rendeable;
import com.byzilio.game.components.Rigidbody;

import java.util.ArrayList;
import java.util.List;

public class MoveYSystem extends System {

    private class MoveObject{

        Rigidbody rb = null;
        Position position = null;

        public boolean isNull(){
            return (rb == null) && (position == null);
        }

    }

    private float scale = 1.0f;

    private List<MoveObject> moveObjects;



    public MoveYSystem() {
        setName("MoveYSystem");
        setDebug(false);
    }

    @Override
    public void create(Engine engine, GameObject gameObject) {
        super.create(engine, gameObject);
        moveObjects = new ArrayList<MoveObject>();
    }

    @Override
    public void preUpdate() {
        log("preUpdate");
        //Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void update() {
        log("update");
        for(int i = 0; i < moveObjects.size(); i++){

        }
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
