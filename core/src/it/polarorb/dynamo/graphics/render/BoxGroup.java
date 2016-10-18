package it.polarorb.dynamo.graphics.render;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erikrahtjen on 10/16/16.
 */
public class BoxGroup extends AbstractBoxGroup {
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
    protected void render(PolygonSpriteBatch spriteBatch) {
        for (int i = 0; i < renderables.size(); i++) {
            renderables.get(i).render(spriteBatch);
        }
    }
}
