package it.polarorb.dynamo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import it.polarorb.dynamo.DynamoDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=1280;
		config.height=900;
		config.title="DynamoDemo v.1";
		new LwjglApplication(new DynamoDemo(), config);
	}
}
