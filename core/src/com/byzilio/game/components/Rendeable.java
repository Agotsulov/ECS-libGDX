package com.byzilio.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.byzilio.engine.Component;

public abstract class Rendeable extends Component {

    public abstract void draw(float x, float y, float scale, SpriteBatch batch);

}
