package it.polarorb.dynamo;

/**
 * Created by erikrahtjen on 10/15/16.
 */
public class Location {
    private float x;
    private float y;
    private float z;

    public Location(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
