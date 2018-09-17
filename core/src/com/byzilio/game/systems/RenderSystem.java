package com.byzilio.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.game.components.Position;
import com.byzilio.game.components.Rendeable;

import java.util.ArrayList;
import java.util.List;

public class RenderSystem extends System{

    /*
        TODO: Придумать как сделать чтобы эта система не зависила от SpriteBatch.
     */

    private class DrawObject{
        List<Rendeable> rendeables = null;
        Position position = null;

        public DrawObject() {
            rendeables = new ArrayList<Rendeable>();
        }

        public boolean isNull(){
            return (rendeables.size() > 0) && (position == null);
        }

    }

    private float scale = 1.0f;

    private List<DrawObject> drawObjects;

    private SpriteBatch batch;


    public RenderSystem() {
        setName("RenderSystem");
        setDebug(false);
    }

    @Override
    public void create(Engine engine) {
        super.create(engine);
        drawObjects = new ArrayList<DrawObject>();
        batch = new SpriteBatch();
    }

    @Override
    public void preUpdate() {
        log("preUpdate");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void update() {
        log("update");
        batch.begin();
        for(int i = 0; i < drawObjects.size(); i++){
            DrawObject current = drawObjects.get(i);
            for(int j = 0; j < current.rendeables.size(); j++){
                Rendeable rendeable = current.rendeables.get(j);
                rendeable.draw(current.position.getX(), current.position.getY(), scale, batch);
            }
        }
        batch.flush();
    }

    @Override
    public void postUpdate() {
        log("postUpdate");
        batch.end();
    }

    @Override
    public void add(GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            DrawObject drawObject = new DrawObject();

            drawObject.position = (Position) e.get("Position");

            if(drawObject.position == null)
                return;

            for (int i = 0; i < e.size(); i++){
                GameObject go = e.get(i);
                if(go instanceof Rendeable)
                    drawObject.rendeables.add((Rendeable) go);
            }

            if(!drawObject.isNull()){
                drawObjects.add(drawObject);
            }
        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            DrawObject drawObject = new DrawObject();

            drawObject.position = (Position) e.get("Position");

            for (int j = 0;j < e.size(); j++){
                GameObject go = e.get(i);
                if(go instanceof Rendeable)
                    drawObject.rendeables.add((Rendeable) go);
            }

            if(!drawObject.isNull()){
                drawObjects.add(i, drawObject);
            }
        }
    }

    @Override
    public int size() {
        return drawObjects.size();
    }

    @Override
    public void clear() {
        drawObjects.clear();
    }

    @Override
    public boolean isEmpty() {
        return drawObjects.isEmpty();
    }

    @Override
    public GameObject remove(int i) {
        GameObject result = drawObjects.get(i).position;
        drawObjects.remove(i);
        return result;
    }

    @Override
    public boolean remove(Object o) {
        return drawObjects.remove(o);
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
