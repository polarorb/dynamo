package it.polarorb.dynamo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

/**
 * Created by erikrahtjen on 10/15/16.
 */
public class IsometricCamera {
    private static final float BEZEL_VERTICAL = .2f;
    private static final float BEZEL_HORIZONTAL = .3f;
    OrthographicCamera camera;
    private float horizontalMovementMultiplier;
    private float verticalMovementMultiplier;
    private float scrollSpeedX = 6.5f;
    private float scrollSpeedY = 4.5f;
    private float percentScrollX;
    private float percentScrollY;

    public IsometricCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
    }

    public void update() {
        camera.position.add(horizontalMovementMultiplier * scrollSpeedX * percentScrollX, verticalMovementMultiplier * scrollSpeedY * percentScrollY, 0);
        camera.update();
    }

    public Matrix4 getProjection() {
        return camera.combined;
    }

    public void onMouseMoved(int mouseLocationX, int mouseLocationY) {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        float bezelLeft = BEZEL_HORIZONTAL * screenWidth;
        float bezelRight = screenWidth - bezelLeft;
        if (mouseLocationX > bezelRight) {
            percentScrollX = (mouseLocationX - bezelRight)/bezelLeft;
            //moving right
            horizontalMovementMultiplier = 1;
        } else if (mouseLocationX < bezelLeft) {
            percentScrollX = (bezelLeft - mouseLocationX)/bezelLeft;
            //moving left
            horizontalMovementMultiplier = -1;
        } else {
            //not moving horizontally
            horizontalMovementMultiplier = 0;
        }

        float bezelBottom = BEZEL_VERTICAL * screenHeight;
        float bezelTop = screenHeight - bezelBottom;
        if (mouseLocationY > bezelTop) {
            percentScrollY = (mouseLocationY - bezelTop)/bezelBottom;
            //moving down
            verticalMovementMultiplier = -1;
        } else if (mouseLocationY < bezelBottom) {
            percentScrollY = (bezelBottom - mouseLocationY)/bezelBottom;
            //moving up
            verticalMovementMultiplier = 1;
        } else {
            //not moving vertically
            verticalMovementMultiplier = 0;
        }
        System.out.println("Mouse Speed:" + percentScrollY);
    }
}
