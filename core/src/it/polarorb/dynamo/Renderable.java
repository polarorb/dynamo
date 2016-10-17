package it.polarorb.dynamo;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

/**
 * Created by erikrahtjen on 10/16/16.
 */
public interface Renderable {
    public void render(IsometricCamera camera, PolygonSpriteBatch spriteBatch);
}
