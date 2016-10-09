package it.polarorb.dynamo.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by erikrahtjen on 10/8/16.
 */
public class ConfigurablePixmap {
    private Pixmap pixmap;
    private Texture texture;

    public ConfigurablePixmap(int width, int height, Pixmap.Format format) {
        pixmap = new Pixmap(width, height, format);
    }

    public ConfigurablePixmap color(Color color) {
        pixmap.setColor(color);
        return this;
    }

    public ConfigurablePixmap drawCircle(int radius) {
        pixmap.drawCircle(pixmap.getWidth()/2, pixmap.getHeight()/2, radius);
        return this;
    }

    public ConfigurablePixmap fillCircle(int radius) {
        pixmap.fillCircle(pixmap.getWidth()/2, pixmap.getHeight()/2, radius);
        return this;
    }

    public ConfigurablePixmap drawCircle(int centerX, int centerY, int radius) {
        pixmap.drawCircle(centerX, centerY, radius);
        return this;
    }

    public ConfigurablePixmap fillCircle(int centerX, int centerY, int radius) {
        pixmap.fillCircle(centerX, centerY, radius);
        return this;
    }

    public ConfigurablePixmap drawRectangle(int x, int y, int width, int height) {
        pixmap.drawRectangle(x, y, width, height);
        return this;
    }

    public ConfigurablePixmap fillRectangle(int x, int y, int width, int height) {
        pixmap.fillRectangle(x, y, width, height);
        return this;
    }

    public ConfigurablePixmap f(ConfigurablePixmap configurablePixmap, int x, int y) {
        pixmap.drawPixmap(configurablePixmap.getPixmap(), x, y);
        return this;
    }

    public ConfigurablePixmap texturize() {
        this.texture = new Texture(pixmap);
        return this;
    }

    public void render(SpriteBatch batch, int x, int y) {
        assert(this.texture != null);
        batch.draw(this.texture, x, y);
    }

    public Pixmap getPixmap() {
        return pixmap;
    }
}
