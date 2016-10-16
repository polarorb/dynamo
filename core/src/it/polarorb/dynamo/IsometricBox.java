package it.polarorb.dynamo;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

class IsometricBox {

    private static final float DEFAULT_WIDTH = 64;
    private static final float DEFAULT_HEIGHT = 32;
    private static final float DEFAULT_DEPTH = (float) Math.sqrt(DEFAULT_HEIGHT*DEFAULT_HEIGHT + DEFAULT_WIDTH*DEFAULT_WIDTH);
    private final float width;
    private final float height;
    private final float depth;

    private float blX;
    private float blY;

    IsometricBox() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_DEPTH);
    }

    private IsometricBox(float width, float height, float depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    private float[] getBaseVertices() {
        return new float[]{
                blX,blY+height/2, // BL
                blX+width/2, blY, // BR
                blX+width, blY + height/2, //TR
                blX + width/2, blY + height //TL
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
                blX, blY + height/2,
                blX + width/2, blY,
                blX + width/2, blY + depth,
                blX, blY + height/2 + depth
        };
    }

    private float[] getRightVertices() {
        return new float[] {
                blX + width/2, blY,
                blX + width, blY + height/2,
                blX + width, blY + + height/2 + depth,
                blX + width/2, blY + height + depth
        };
    }

    PolygonRegion getFloorPolygonRegion() {
        // Creating the color filling (but textures would work the same way)
        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
        pix.fill();

        Texture textureSolid = new Texture(pix);

        PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
                getBaseVertices(), new short[] {
                0, 1, 2,         // Two triangles using vertex indices.
                2, 3, 0          // Take care of the counter-clockwise direction.
        });

        return polyReg;
    }


    PolygonRegion getLeftPolygonRegion() {
        // Creating the color filling (but textures would work the same way)
        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
        pix.fill();

        Texture textureSolid = new Texture(pix);

        PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
                getLeftVertices(), new short[] {
                0, 1, 2,         // Two triangles using vertex indices.
                2, 3, 0          // Take care of the counter-clockwise direction.
        });

        return polyReg;
    }

    PolygonRegion getRightPolygonRegion() {
        // Creating the color filling (but textures would work the same way)
        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
        pix.fill();

        Texture textureSolid = new Texture(pix);

        PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
                getRightVertices(), new short[] {
                0, 1, 2,         // Two triangles using vertex indices.
                2, 3, 0          // Take care of the counter-clockwise direction.
        });

        return polyReg;
    }

    PolygonRegion getRoofPolygonRegion() {
        // Creating the color filling (but textures would work the same way)
        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(0xDEADBEFF); // DE is red, AD is green and BE is blue.
        pix.fill();

        Texture textureSolid = new Texture(pix);

        PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
                getRoofVertices(), new short[] {
                0, 1, 2,         // Two triangles using vertex indices.
                2, 3, 0          // Take care of the counter-clockwise direction.
        });

        return polyReg;
    }
}
