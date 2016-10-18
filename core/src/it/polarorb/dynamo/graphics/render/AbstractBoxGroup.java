package it.polarorb.dynamo.graphics.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

/**
 * Created by erikrahtjen on 10/18/16.
 */
public abstract class AbstractBoxGroup implements Renderable {
    protected abstract void render(PolygonSpriteBatch spriteBatch);

    @Override
    public void render(Batch spriteBatch) {
        render((PolygonSpriteBatch) spriteBatch);
    }
}
