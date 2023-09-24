package com.mygdx.firstrpg.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;

public class Player extends MovableObject {

    public Player() {
        setDynamics(350f, 250f, 100f, 100f);
        setSprite("Player");
        setVelocity(350f);
        setAnimated(true);
        setAnimationTime(0.1f);
        setAnimation("Player", Animation.PlayMode.LOOP_PINGPONG);
    }
    @Override
    public void move(float delta) {
        boolean pressed = false;
        float positionUpdate = velocity * delta;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += positionUpdate;
            pressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= positionUpdate;
            pressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += positionUpdate;
            pressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= positionUpdate;
            pressed = true;
        }
        setAnimated(pressed, 0.1f);
        updateHitBox();
    }
}
