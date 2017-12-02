package game.scenes;

import bases.GameObject;
import bases.inputs.InputManager;
import bases.renderers.ImageRenderer;
import bases.scenes.Scene;
import bases.scenes.SceneManager;

public class GameStartScene implements Scene{

    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject background = new GameObject();
        background.renderer = new ImageRenderer("assets/images/scene/GameStartScene.png");
        GameObject.add(background);

    }
}
