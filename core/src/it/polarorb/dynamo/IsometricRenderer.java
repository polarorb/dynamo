package it.polarorb.dynamo;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by erikrahtjen on 10/15/16.
 */
public class IsometricRenderer {
    private ShapeRenderer shapeRenderer;

    public IsometricRenderer() {
        this.shapeRenderer = new ShapeRenderer();
    }

    public void render() {
        this.shapeRenderer.begin();
    }
}
