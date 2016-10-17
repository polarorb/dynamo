package it.polarorb.dynamo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DynamoDemo extends ApplicationAdapter {
	private static final int COLUMNS = 1;
	private static final int ROWS = 1;
	SpriteBatch batch;
	Texture img;
	private PolygonSpriteBatch spriteBatch;
	private IsometricBox box;
	private IsometricCamera camera;
	private InputProcessor inputProcessor;
    private BoxGroup northWestWallTile;

    @Override
	public void create () {
		batch = new SpriteBatch();
		spriteBatch = new PolygonSpriteBatch();
        IsometricBox floor = new IsometricBox(IsometricBox.DEFAULT_WIDTH*3, IsometricBox.DEFAULT_HEIGHT*3, 2);
        IsometricBox wall = new IsometricBox(2, floor.getHeight(), IsometricBox.DEFAULT_DEPTH);
        wall.setScreenY(floor.a());
        IsometricBox owall = new IsometricBox(floor.getWidth(), 2, IsometricBox.DEFAULT_DEPTH);
        owall.setScreenX(floor.c());
        owall.setScreenY(floor.d());
        IsometricBox wall2 = new IsometricBox(2, floor.getHeight(), IsometricBox.DEFAULT_DEPTH);
        wall2.setScreenX(floor.b());
        northWestWallTile = new BoxGroup(floor, wall, owall, wall2);
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
        northWestWallTile.render(camera, spriteBatch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		spriteBatch.dispose();
	}
}
