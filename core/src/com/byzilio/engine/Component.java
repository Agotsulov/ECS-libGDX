package com.byzilio.engine;

public abstract class Component extends GameObject{

    private Entity entity;

    /*
        Это не очень хорошо.
        TODO:Придумать как запихать Entity получше.
        Хотя я все больше склоняюсь к написанию ECS через один класс GameObject,
     */

    public void create(Engine engine, Entity entity) {
        create(engine);
        setEntity(entity);
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

}
