package it.polarorb.dynamo;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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

    private float blX;
    private float blY;

    public IsometricBox() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_DEPTH);
    }

    public IsometricBox(float width, float height, float depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public float[] getFloorVertices() {
        return new float[]{
                blX,blY+height/2, // BL
                blX+width/2, blY, // BR
                blX+width, blY + height/2, //TR
                blX + width/2, blY + height //TL
        };
    }

    public PolygonRegion getFloorPolygonRegion() {
        // Creating the color filling (but textures would work the same way)
        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
        pix.fill();

        Texture textureSolid = new Texture(pix);

        PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
                getFloorVertices(), new short[] {
                0, 1, 2,         // Two triangles using vertex indices.
                2, 3, 0          // Take care of the counter-clockwise direction.
        });

        return polyReg;
    }

    public PolygonSprite getFloorPolygonSprite() {
        PolygonSprite poly;
        PolygonRegion polyReg = getFloorPolygonRegion();
        poly = new PolygonSprite(polyReg);
        poly.setOrigin(blX, blY);
        return poly;
    }
}
