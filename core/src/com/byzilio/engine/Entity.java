package com.byzilio.engine;

import java.lang.reflect.Type;
import java.util.List;

public abstract class Entity extends GameObject implements Container<GameObject> {

    public abstract GameObject get(String name);

    public abstract GameObject get(Class c);

    public abstract List<GameObject> getAll(String name);

    public abstract List<GameObject> getAll(Class c);


}
