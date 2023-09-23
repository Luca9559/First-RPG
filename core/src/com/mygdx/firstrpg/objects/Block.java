package com.mygdx.firstrpg.objects;

public class Block extends PlainObject {

    public Block() {
        setDynamics(100f, 200f, 100f, 100f);
        this.setSprite("Block");
    }
}
