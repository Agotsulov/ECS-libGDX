package com.byzilio.engine;

public interface Container<T extends GameObject> {

    void add(T t);

    void add(int i,T t);

    T get(int i);

    int size();

    void clear();

    boolean isEmpty();

    T remove(int i);

    boolean remove(Object o);

}
