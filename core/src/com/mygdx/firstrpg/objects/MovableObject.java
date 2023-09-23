package com.mygdx.firstrpg.objects;

public abstract class  MovableObject extends PlainObject{

    protected float velocity = 250f;

    public abstract void move(float delta);


    public float moveUp(float delta) {
        float positionUpdate = velocity * delta;
        position.y += positionUpdate;
        return positionUpdate;
    }
    public float moveDown(float delta) {
        float positionUpdate = velocity * delta;
        position.y -= positionUpdate;
        return positionUpdate;
    }

    public float moveLeft(float delta) {
        float positionUpdate = velocity * delta;
        position.x -= positionUpdate;
        return positionUpdate;
    }

    public float moveRight(float delta) {
        float positionUpdate = velocity * delta;
        position.x += positionUpdate;
        return positionUpdate;
    }

    public float getVelocity() {return velocity;}
    public void setVelocity(float velocity) {this.velocity = velocity;}

}
