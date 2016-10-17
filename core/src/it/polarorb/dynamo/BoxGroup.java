package it.polarorb.dynamo;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erikrahtjen on 10/16/16.
 */
public class BoxGroup implements Renderable {
    List<IsometricBox> renderables;

    public BoxGroup(IsometricBox... isometricBoxes) {
        renderables = new ArrayList<IsometricBox>();
        for (int i = 0; i < isometricBoxes.length; i++) {
            renderables.add(isometricBoxes[i]);
        }
    }

    public BoxGroup(List<IsometricBox> boxList) {
        this((IsometricBox[]) boxList.toArray());
    }

    @Override
    public void render(IsometricCamera camera, PolygonSpriteBatch spriteBatch) {
        for (IsometricBox box : renderables) {
            box.render(camera, spriteBatch);
        }
    }

}
