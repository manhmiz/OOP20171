package game.players;

import bases.Utils;
import bases.inputs.InputManager;
import bases.physics.Vector2d;
import bases.renderers.Animation;
import bases.renderers.Renderer;

import java.awt.*;

public class PlayerAnimator implements Renderer {
    public Animation leftAnimation;
    public Animation rightAnimation;
    public Animation upAnimation;
    public Animation downAnimation;
    public Animation currentAnimation;

    public PlayerAnimator() {

    }

    public void run() {

        InputManager inputManager = InputManager.instance;
        switch (inputManager.BULLET_MOVE) {
            case 1:
                currentAnimation = leftAnimation;
                break;
            case 2:
                currentAnimation = rightAnimation;
                break;
            case 3:
                currentAnimation = upAnimation;
                break;
            case 4:
                currentAnimation = downAnimation;
                break;
        }
    }

    @Override
    public void render(Graphics graphics, Vector2d position) {

        currentAnimation.render(graphics, position);
    }
}
