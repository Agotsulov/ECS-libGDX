package com.byzilio.engine.core;

public interface Debugable {

    // TODO: Доделать, а то обычними способоми уже трудно дебажить. Может сделать VM.

    boolean isDebug();

    void setDebug(boolean debug);

    void log(String massage);
}
