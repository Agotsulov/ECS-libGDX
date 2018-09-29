package com.byzilio.common.systems;

import com.byzilio.common.components.Button;
import com.byzilio.common.components.core.Script;
import com.byzilio.engine.Component;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.engine.core.Container;
import com.byzilio.engine.core.Input;

import java.util.ArrayList;
import java.util.List;

public class GUISystem extends System{

    private class GUIObject {

        public List<Script> scripts;
        public Button button;

        public GUIObject(Container<Component> scripts, Button button) {
            this.scripts = new ArrayList<Script>();
            this.button = button;
            for(int i = 0;i < scripts.size();i++){
                Component c = scripts.get(i);
                if(c instanceof Script)
                    this.scripts.add((Script) c);
            }
        }
    }

    private Input input;

    private List<GUIObject> guiObjects;

    private int countCheckableTouch = 5;

    public GUISystem() {
        guiObjects = new ArrayList<GUIObject>();
    }

    @Override
    public void start() {
        input = engine.input;
    }

    @Override
    public void preUpdate() {
        for(int i = 0;i < guiObjects.size();i++){
            GUIObject current = guiObjects.get(i);
            Button button = current.button;

            for(int p = 0;p < countCheckableTouch;p++) {
                int x = input.getKey("touchX_" + p);
                int y = input.getKey("touchY_" + p);

                if ((button.getX() <= x)
                        && (x <= button.getX() + button.getW())
                        && (button.getY() <= y)
                        && (y <= button.getY() + button.getH())
                        )
                    for (int j = 0; j < current.scripts.size(); j++)
                        current.scripts.get(j).onClick();
            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void postUpdate() {

    }

    @Override
    public void add(GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;

            Container<Component> scripts = e.getAll(Script.class);
            Container<Component> buttons = e.getAll(Button.class);

            for(int i = 0;i < buttons.size();i++)
                if(buttons.get(i) instanceof Button) {
                    GUIObject o = new GUIObject(scripts, (Button) buttons.get(i));
                    guiObjects.add(o);
                }
        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;

            Container<Component> scripts = e.getAll(Script.class);
            Container<Component> buttons = e.getAll(Button.class);

            for(int j = 0;j < buttons.size();j++)
                if(buttons.get(j) instanceof Button) {
                    GUIObject o = new GUIObject(scripts, (Button) buttons.get(j));
                    guiObjects.add(i, o);
                }
        }
    }

    @Override
    public int size() {
        return guiObjects.size();
    }

    @Override
    public void clear() {
        guiObjects.clear();
    }

    @Override
    public boolean isEmpty() {
        return guiObjects.isEmpty();
    }

    @Override
    public GameObject remove(int i) {
        guiObjects.remove(i);
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return guiObjects.remove(o);
    }

    @Override
    public void dispose() {

    }
}
