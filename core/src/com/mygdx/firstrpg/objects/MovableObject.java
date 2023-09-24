package com.mygdx.firstrpg.objects;

public abstract class  MovableObject extends PlainObject{

    protected float velocity = 250f;

    public abstract void move(float delta);

    public float getVelocity() {return velocity;}
    public void setVelocity(float velocity) {this.velocity = velocity;}

}
