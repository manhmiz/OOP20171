package game.scenes;

import bases.GameObject;
import bases.renderers.ImageRenderer;
import bases.scenes.Scene;

public class GameOverScene implements Scene{
    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        GameObject background = new GameObject();
        background.renderer = new ImageRenderer("assets/images/scene/GameOver.png");
        GameObject.add(background);

    }
}
