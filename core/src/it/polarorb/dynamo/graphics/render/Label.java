package it.polarorb.dynamo.graphics.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by erikrahtjen on 10/18/16.
 */
public class Label implements Renderable, Disposable {

    public static final BitmapFont DEFAULT_FONT = new BitmapFont(new FileHandle("core/assets/debug.fnt"));
    public static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;

    BitmapFont font;
    Color color;
    String string;
    private float topLeftY;
    private float topLeftX;

    public Label() {
        this(DEFAULT_FONT, DEFAULT_COLOR, "", 0, 0);
    }

    public Label(String string) {
        this(DEFAULT_FONT, DEFAULT_COLOR, string, 0, 0);
    }

    private Label(BitmapFont font, Color color, String string, float x, float y) {
        this.font = font;
        this.font.getData().setScale(.45f);
        this.color = color;
        this.string = string;
        this.topLeftX = x;
        this.topLeftY = y;
    }

    public void setTopLeftX(float topLeftX) {
        this.topLeftX = topLeftX;
    }

    public void setTopLeftY(float topLeftY) {
        this.topLeftY = topLeftY;
    }

    @Override
    public void render(Batch spriteBatch) {
        font.draw(spriteBatch, string, topLeftX, topLeftY, Gdx.graphics.getWidth(), Align.topLeft, true);
    }

    @Override
    public void dispose() {
        this.font.dispose();
    }
}
