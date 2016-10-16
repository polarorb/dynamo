package it.polarorb.dynamo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DynamoDemo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private PolygonSpriteBatch spriteBatch;
	private IsometricBox box;
	private IsometricCamera camera;
	private InputProcessor inputProcessor;

	@Override
	public void create () {
		batch = new SpriteBatch();
		spriteBatch = new PolygonSpriteBatch();
		box = new IsometricBox();
		img = new Texture("core/assets/badlogic.jpg");
		camera = new IsometricCamera();

		inputProcessor = new InputProcessor() {
			@Override
			public boolean keyDown(int keycode) {
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}

			@Override
			public boolean mouseMoved(int mouseLocationX, int mouseLocationY) {
				camera.onMouseMoved(mouseLocationX, mouseLocationY);
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				return false;
			}
		};
		Gdx.input.setInputProcessor(this.inputProcessor);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		spriteBatch.setProjectionMatrix(camera.getProjection());
		spriteBatch.begin();
		spriteBatch.setColor(Color.LIGHT_GRAY);
		spriteBatch.draw(box.getLeftPolygonRegion(), 0, 0);
		spriteBatch.setColor(Color.GRAY);
		spriteBatch.draw(box.getRightPolygonRegion(), 0, 0);
		spriteBatch.setColor(Color.DARK_GRAY);
		spriteBatch.draw(box.getRoofPolygonRegion(), 0, 0);
		spriteBatch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		spriteBatch.dispose();
	}
}
