package com.byzilio.game.other;

public interface Vector {

    /*
        Вообще этот интерфейс не по SOLID и не очень.
        Но всё тут 2D ,так что сойдет.
        TODO: Ввести n-мерный вектор
     */

    float getX();

    float getY();

    void setX(float x);

    void setY(float y);

    Vector add(float x, float y);

    Vector add(Vector v);

    float angle();

    float dot(float ox, float oy);

    float dst(float x, float y);

    boolean isZero();

    float len();

    Vector limit(float limit);

    Vector nor();

    Vector rotate(float degrees);

    Vector scl(float scalar);

    Vector scl(float x, float y);

    Vector scl(Vector v);

    Vector set(float x, float y);

    Vector set(Vector v);

    Vector setAngle(float degrees);

    Vector setLength(float length);

    Vector setZero();

    Vector sub(float x, float y);

    Vector sub(Vector v);

}


