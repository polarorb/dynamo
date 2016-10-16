package it.polarorb.dynamo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

/**
 * Created by erikrahtjen on 10/15/16.
 */
public class IsometricCamera {
    private static final int BEZEL = 40;
    OrthographicCamera camera;
    private float horizontalMovementMultiplier;
    private float verticalMovementMultiplier;
    private float scrollSpeed = 1.1f;

    public IsometricCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true);
    }

    public void update() {
        camera.position.add(horizontalMovementMultiplier*scrollSpeed, verticalMovementMultiplier*scrollSpeed, 0);
        camera.update();
    }

    public Matrix4 getProjection() {
        return camera.combined;
    }

    public void onMouseMoved(int mouseLocationX, int mouseLocationY) {
        System.out.println("Mouse Loc:" + mouseLocationX + ", " + mouseLocationY);
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        if (mouseLocationX > screenWidth - BEZEL) {
            //moving right
            horizontalMovementMultiplier = 1;
        } else if (mouseLocationX < BEZEL) {
            //moving left
            horizontalMovementMultiplier = -1;
        } else {
            //not moving horizontally
            horizontalMovementMultiplier = 0;
        }

        if (mouseLocationY < BEZEL) {
            //moving up
            verticalMovementMultiplier = -1;
        } else if (mouseLocationY > screenHeight - BEZEL) {
            //moving down
            verticalMovementMultiplier = 1;
        }
        else {
            //not moving vertically
            verticalMovementMultiplier = 0;
        }
    }
}
