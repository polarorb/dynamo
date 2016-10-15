package it.polarorb.dynamo;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by erikrahtjen on 10/15/16.
 */
public class IsometricBox {

    private static final float DEFAULT_WIDTH = 64;
    private static final float DEFAULT_HEIGHT = 32;
    private static final float DEFAULT_DEPTH = 0;
    private final float width;
    private final float height;
    private final float depth;

    private Location location;

    public IsometricBox() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_DEPTH);
    }

    public IsometricBox(float width, float height, float depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public void render(ShapeRenderer shapeRenderer, Location location) {

    }
}
