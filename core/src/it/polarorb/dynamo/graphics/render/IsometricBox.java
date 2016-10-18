package it.polarorb.dynamo.graphics.render;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class IsometricBox extends AbstractBoxGroup {

    public static final float DEFAULT_WIDTH = 64;
    public static final float DEFAULT_HEIGHT = 64;
    public static final float DEFAULT_DEPTH = 64;
    private final float width;
    private final float height;
    private final float depth;

    private float bottomLeftX;
    private float bottomLeftY;
    private float screenX;
    private float screenY;
    private PolygonRegion rightPolygonRegion;
    private PolygonRegion leftPolygonRegion;
    private PolygonRegion roofPolygonRegion;

    IsometricBox() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_DEPTH);
    }

    public IsometricBox(float width, float height, float depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public float a() {
        return width/2f;
    }

    public float b() {
        return (float) (Math.sqrt(3f)*a());
    }

    public float d() {
        return height/2f;
    }

    public float c() {
        return (float) (Math.sqrt(3f)*d());
    }

    private float[] getBaseVertices() {
        return new float[]{
                bottomLeftX, bottomLeftY +a(), // BL
                bottomLeftX +b(), bottomLeftY, // BR
                bottomLeftX +b()+c(), bottomLeftY + d(), //TR
                bottomLeftX + c(), bottomLeftY + a()+d() //TL
        };
    }

    private float[] getRoofVertices() {
        float[] base = getBaseVertices();
        for (int i = 1; i < base.length; i=i+2) {
            base[i] += depth;
        }

        return base;
    }

    private float[] getLeftVertices() {
        return new float[] {
                bottomLeftX, bottomLeftY + a(),
                bottomLeftX + b(), bottomLeftY,
                bottomLeftX + + b(), bottomLeftY + depth,
                bottomLeftX, bottomLeftY + a() + depth
        };
    }

    private float[] getRightVertices() {
        return new float[] {
                bottomLeftX + b(), bottomLeftY,
                bottomLeftX + b() + c(), bottomLeftY + d(),
                bottomLeftX + b() + c(), bottomLeftY + d() + depth,
                bottomLeftX + b(), bottomLeftY +  depth
        };
    }

    PolygonRegion getLeftPolygonRegion() {
        if (leftPolygonRegion == null) {
            // Creating the color filling (but textures would work the same way)
            Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
            pix.fill();

            Texture textureSolid = new Texture(pix);

            leftPolygonRegion = new PolygonRegion(new TextureRegion(textureSolid),
                    getLeftVertices(), new short[] {
                    0, 1, 2,         // Two triangles using vertex indices.
                    2, 3, 0          // Take care of the counter-clockwise direction.
            });
        }

        return leftPolygonRegion;
    }

    PolygonRegion getRightPolygonRegion() {
        if (rightPolygonRegion == null) {
            // Creating the color filling (but textures would work the same way)
            Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
            pix.fill();

            Texture textureSolid = new Texture(pix);

            rightPolygonRegion = new PolygonRegion(new TextureRegion(textureSolid),
                    getRightVertices(), new short[] {
                    0, 1, 2,         // Two triangles using vertex indices.
                    2, 3, 0          // Take care of the counter-clockwise direction.
            });
        }

        return rightPolygonRegion;
    }

    PolygonRegion getRoofPolygonRegion() {
        if (roofPolygonRegion == null) {
            // Creating the color filling (but textures would work the same way)
            Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
            pix.fill();

            Texture textureSolid = new Texture(pix);

            roofPolygonRegion = new PolygonRegion(new TextureRegion(textureSolid),
                    getRoofVertices(), new short[] {
                    0, 1, 2,         // Two triangles using vertex indices.
                    2, 3, 0          // Take care of the counter-clockwise direction.
            });
        }

        return roofPolygonRegion;
    }

    public void setScreenX(float screenX) {
        this.screenX = screenX;
    }

    public void setScreenY(float screenY) {
        this.screenY = screenY;
    }

    @Override
    public void render(PolygonSpriteBatch spriteBatch) {
        spriteBatch.setColor(Color.LIGHT_GRAY);
        spriteBatch.draw(getLeftPolygonRegion(), getScreenX(), getScreenY());
        spriteBatch.setColor(Color.GRAY);
        spriteBatch.draw(getRightPolygonRegion(), getScreenX(), getScreenY());
        spriteBatch.setColor(Color.DARK_GRAY);
        spriteBatch.draw(getRoofPolygonRegion(), getScreenX(), getScreenY());
    }

    public float getScreenX() {
        return screenX;
    }

    public float getScreenY() {
        return screenY;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
