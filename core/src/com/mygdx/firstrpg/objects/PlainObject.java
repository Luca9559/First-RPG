package com.mygdx.firstrpg.objects;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.firstrpg.FirstRPG;

public abstract class PlainObject {


    private final TextureAtlas atlas = FirstRPG.manager.get("textureatlas/texturepack.atlas");
    private TextureRegion sprite;
    protected Rectangle hitBox = new Rectangle();
    protected float height = 50f;
    protected float width = 50f;
    protected Vector2 position = new Vector2(0, 0);
    protected boolean isAnimated = false;
    protected Animation<TextureRegion> animation;
    protected float animationTime = 0;
    protected OrthographicCamera boundCamera = null;

    public boolean collides(Rectangle hitBox) {
        return this.hitBox.overlaps(hitBox);
    }

    public void render(SpriteBatch batch, float delta) {
        if (isAnimated) {
            animationTime += delta;
            batch.draw(animation.getKeyFrame(animationTime), position.x, position.y, width, height);
        } else {
            batch.draw(sprite, position.x, position.y, width, height);
        }
    }

    public void setDynamics(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;
        updateHitBox();
    }

    public void updateHitBox() {
        this.hitBox.x = this.position.x;
        this.hitBox.y = this.position.y;
        this.hitBox.width = this.width;
        this.hitBox.height = this.height;
    }
    public void dispose() {
        this.atlas.dispose();
    }

    public void setSprite(String region) {
        this.sprite = atlas.findRegion(region);
    }

    public void setAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    public void setAnimated(boolean isAnimated, float resetTime) {
        if (!isAnimated) {
            this.animationTime = resetTime;
        }
        this.isAnimated = isAnimated;
    }

    public void setAnimation(String region, Animation.PlayMode playMode) {
        this.animation = new Animation<TextureRegion>(animationTime, atlas.findRegions(region), playMode);
    }

    public void setAnimationTime(float animationTime) {
        this.animationTime = animationTime;
    }

    public void attachCamera(OrthographicCamera camera) {
        this.boundCamera = camera;
    }

    public void detachCamera() {
        this.boundCamera = null;
    }

}
