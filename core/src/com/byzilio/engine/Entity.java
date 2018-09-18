package com.byzilio.engine;

import com.byzilio.engine.core.Container;

public abstract class Entity extends Component implements Container<Component> {
    //Зато это теперь тру-ECS


    @Override
    public void rebirth() {
        super.rebirth();
        for(int i = 0;i < size();i++){
            get(i).rebirth();
        }
    }

    @Override
    public void kill() {
        super.kill();
        for(int i = 0;i < size();i++)
            get(i).kill();
    }
}
