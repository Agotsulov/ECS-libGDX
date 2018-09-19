package com.byzilio.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.game.components.Position;
import com.byzilio.game.components.Renderable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RenderSystem extends System{

    /*
        TODO: Придумать как сделать чтобы эта система не зависила от SpriteBatch.
        TODO: Камеру.
     */

    private class DrawObject implements Comparable<DrawObject>{
        Renderable renderable = null;
        Position position = null;

        public boolean isNull(){
            return (renderable == null) || (position == null);
        }

        @Override
        public int compareTo(DrawObject drawObject) {
            return renderable.getLayer() - drawObject.renderable.getLayer();
        }
    }

    private float scale = 1.0f;

    private List<DrawObject> drawObjects;

    private SpriteBatch batch;

    public RenderSystem() {
        setName("RenderSystem");
        setDebug(false);
        setScale(1.0f);
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
            current.renderable.draw(current.position.getX(), current.position.getY(), scale, batch);
            //Кстати лучше так или java умная и не будет на каждый drawObjects.get(i) доствать?
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

            drawObject.position = (Position) e.get(Position.class);
            drawObject.renderable = (Renderable) e.get(Renderable.class);

            if(!drawObject.isNull()){
                drawObjects.add(drawObject);
                Collections.sort(drawObjects); //Долго но пойдет
            }
        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;

            DrawObject drawObject = new DrawObject();

            drawObject.position = (Position) e.get(Position.class);
            drawObject.renderable = (Renderable) e.get(Renderable.class);

            if(!drawObject.isNull()){
                drawObjects.add(i, drawObject);
                Collections.sort(drawObjects);
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

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
