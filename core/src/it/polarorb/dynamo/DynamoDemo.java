package it.polarorb.dynamo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import it.polarorb.dynamo.graphics.ConfigurablePixmap;

public class DynamoDemo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private ConfigurablePixmap confPixmap;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		confPixmap = new ConfigurablePixmap(50, 50, Pixmap.Format.RGBA8888);
        confPixmap.color(Color.BLACK).fillCircle(25).color(Color.WHITE).fillCircle(24).texturize();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		confPixmap.render(batch, 45, 45);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
