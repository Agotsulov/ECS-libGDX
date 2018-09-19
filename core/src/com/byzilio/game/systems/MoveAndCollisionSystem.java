package com.byzilio.game.systems;

import com.byzilio.engine.Component;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.engine.core.Container;
import com.byzilio.game.components.core.Collider;
import com.byzilio.game.components.Position;
import com.byzilio.game.components.Rigidbody;
import com.byzilio.game.components.core.Script;
import com.byzilio.game.core.ArrayListContainer;
import com.byzilio.game.other.Pair;

import java.util.ArrayList;
import java.util.List;

public class MoveAndCollisionSystem extends System {
    /*
        Тут не додалено.
        Так как данная система создает в игровом цикле приведение типов.
        И он вообще не по SOLID.
        И я в ней запутался уже.
        Проще сразу сделать нормально.
        TODO: Переделать всё. Сделать обработку ДО движения. Переделать через треугольники. Разделить на две системы
     */

    private class MoveObject{
        Rigidbody rb = null;
        Position position = null;

        public boolean isNull(){
            return (rb == null) || (position == null);
        }
    }

    private class CollideObject{
        Entity entity = null;
        Position position = null;
        Container<Collider> collides = null;
        Container<Script> scripts = null;

        public CollideObject() {
            collides = new ArrayListContainer<Collider>();
            scripts = new ArrayListContainer<Script>();
        }

        public boolean isNull(){
            return (entity == null) || (collides.size() > 0) || (position == null);
        }
    }

    private List<MoveObject> moveObjects;
    private List<CollideObject> collideObjects;
    private List<Pair<CollideObject, Entity>> result;

    public MoveAndCollisionSystem() {
        setName("MoveSystem");
        setDebug(true);
    }

    @Override
    public void create(Engine engine) {
        super.create(engine);
        moveObjects = new ArrayList<MoveObject>();
        collideObjects = new ArrayList<CollideObject>();
        result = new ArrayList<Pair<CollideObject, Entity>>();
    }

    @Override
    public void preUpdate() {
        log("preUpdate");
    }

    @Override
    public void update() {
        log("update");

        for(int i = 0; i < moveObjects.size(); i++)
            moveX(moveObjects.get(i));

        for(int i = 0; i < collideObjects.size(); i++)
            collideX(collideObjects.get(i));

        for(int i = 0; i < moveObjects.size(); i++)
            moveObjects.get(i).rb.setAx(0);


        for(int i = 0; i < moveObjects.size(); i++)
            moveY(moveObjects.get(i));

        for(int i = 0; i < collideObjects.size(); i++)
            collideY(collideObjects.get(i));

        for(int i = 0; i < moveObjects.size(); i++)
            moveObjects.get(i).rb.setAy(0);

        for(int i = 0; i < result.size(); i++){
            CollideObject collideObject = result.get(i).getFirst();
            for(int s = 0; s < collideObject.scripts.size(); s++){
                collideObject.scripts.get(s).onCollision(result.get(i).getSecond());
            }
        }


    }

    private void collideX(CollideObject curr){
        for(int i = 0;i < collideObjects.size();i++){
            CollideObject collideObject = collideObjects.get(i);

            if(collideObject == curr)
                return;

            for(int j = 0;j < collideObject.collides.size();j++)
                for(int k = 0;k < curr.collides.size();k++)
                    if(curr.collides.get(k).check(
                            collideObject.position, collideObject.collides.get(j))
                            ){
                        result.add(new Pair<CollideObject, Entity>(curr, collideObject.entity));
                        result.add(new Pair<CollideObject, Entity>(collideObject, curr.entity));
                        if (!curr.collides.get(k).isTrigger()) {
                            //repelX
                        }
                    }

        }
    }

    private void collideY(CollideObject curr){
        for(int i = 0;i < collideObjects.size();i++){
            CollideObject collideObject = collideObjects.get(i);

            if(collideObject == curr)
                return;

            for(int j = 0;j < collideObject.collides.size();j++)
                for(int k = 0;k < curr.collides.size();k++)
                    if(curr.collides.get(k).check(
                            collideObject.position, collideObject.collides.get(j))
                            ){
                        result.add(new Pair<CollideObject, Entity>(curr, collideObject.entity));
                        result.add(new Pair<CollideObject, Entity>(collideObject, curr.entity));
                        if (!curr.collides.get(k).isTrigger()) {
                            //repelY
                        }
                    }

        }
    }

    private void repelX(MoveObject curr){

    }

    private void repelY(MoveObject curr){

    }


    private void moveX(MoveObject curr){
        if(curr.rb.getAx() != 0){
            curr.rb.setUx(curr.rb.getUx() + curr.rb.getAx());
        } else {
            if ((curr.rb.getDrag() != 0) &&
                    ((curr.rb.getUx() < curr.rb.getDrag())
                            || (curr.rb.getUx() > -curr.rb.getDrag())))
                curr.rb.setUx(0);
            if (curr.rb.getUx() > 0)
                curr.rb.setUx(curr.rb.getUx() - curr.rb.getDrag());
            if (curr.rb.getUx() < 0)
                curr.rb.setUx(curr.rb.getUx() + curr.rb.getDrag());
        }

        if(curr.rb.getUx() > curr.rb.getMaxUx())
            curr.rb.setUx(curr.rb.getMaxUx());

        curr.position.setX(curr.position.getX() + curr.rb.getUx());

    }

    private void moveY(MoveObject curr){
        if(curr.rb.getAy() != 0){
            curr.rb.setUy(curr.rb.getUy() + curr.rb.getAy());
        } else {
            if ((curr.rb.getDrag() != 0)
                    && ((curr.rb.getUy() < curr.rb.getDrag())
                    || (curr.rb.getUy() > -curr.rb.getDrag()))
                    )
                curr.rb.setUy(0);
            if (curr.rb.getUy() > 0)
                curr.rb.setUy(curr.rb.getUy() - curr.rb.getDrag());
            if (curr.rb.getUy() < 0)
                curr.rb.setUy(curr.rb.getUy() + curr.rb.getDrag());
        }

        if(curr.rb.getUy() > curr.rb.getMaxUy())
            curr.rb.setUy(curr.rb.getMaxUy());

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

            if(!moveObject.isNull())
                moveObjects.add(moveObject);


            CollideObject collideObject = new CollideObject();

            collideObject.entity = e;
            collideObject.position = (Position) e.get(Position.class);
            for(int i = 0;i < e.size();i++){
                Component c = e.get(i);
                if(c instanceof Collider)
                    collideObject.collides.add((Collider) c);
            }
            for(int i = 0;i < e.size();i++){
                Component c = e.get(i);
                if(c instanceof Script)
                    collideObject.scripts.add((Script) c);
            }

            if(!collideObject.isNull())
                collideObjects.add(collideObject);

        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            MoveObject moveObject = new MoveObject();

            moveObject.position = (Position) e.get(Position.class);
            moveObject.rb = (Rigidbody) e.get(Rigidbody.class);

            if(!moveObject.isNull())
                moveObjects.add(i, moveObject);


            CollideObject collideObject = new CollideObject();

            collideObject.entity = e;
            collideObject.position = (Position) e.get(Position.class);
            for(int j = 0;j < e.size();j++){
                Component c = e.get(i);
                if(c instanceof Collider)
                    collideObject.collides.add((Collider) c);
            }
            for(int j = 0;j < e.size();j++){
                Component c = e.get(i);
                if(c instanceof Script)
                    collideObject.scripts.add((Script) c);
            }

            if(!collideObject.isNull())
                collideObjects.add(i, collideObject);

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
