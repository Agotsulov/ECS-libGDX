package com.byzilio.engine;

public abstract class Component extends GameObject{

    private Entity entity;

    protected boolean alive = true;


    /*
        Это не очень хорошо.
        TODO: Придумать как запихать Entity получше.
        Хотя я все больше склоняюсь к написанию ECS через один класс GameObject,
     */

    public void create(Engine engine, Entity entity) {
        create(engine);
        setEntity(entity);
        rebirth();
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void rebirth(){
        alive = true;
    }

    public void kill(){
        alive = false;
    }

}
