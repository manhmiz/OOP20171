package game.enemies;

import bases.Utils;
import bases.physics.Vector2d;
import bases.renderers.Animation;
import bases.renderers.Renderer;
import game.players.Player;

import javax.swing.*;
import java.awt.*;

public class EnemyAnimator implements Renderer {
    public Animation leftAnimation;
    public Animation rightAnimation;
    public Animation upAnimation;
    public Animation downAnimation;
    public Animation currentAnimation;

    public EnemyAnimator() {
        leftAnimation = new Animation(Utils.loadImage("assets/images/enemies/level0/zombie_left.png"));
        rightAnimation = new Animation(Utils.loadImage("assets/images/enemies/level0/zombie_right.png"));
        upAnimation = new Animation(Utils.loadImage("assets/images/enemies/level0/zombie_up.png"));
        downAnimation = new Animation(Utils.loadImage("assets/images/enemies/level0/zombie_down.png"));

        currentAnimation = downAnimation;
    }

    @Override
    public void render(Graphics graphics, Vector2d position) {
        currentAnimation.render(graphics, position);
    }
}
